package school.poly.project.pages;

import lombok.SneakyThrows;
import school.poly.project.RecipeMainApplication;
import school.poly.project.messageBox.ErrorBox;
import school.poly.project.sqlUnit.GivenConnect;
import school.poly.project.status.CookProcess;
import school.poly.project.users.Cook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TaeWK
 */
public class WriteMenuPage extends JPanel {

    public static JTextField cook_name = new JTextField("요리의 이름은 무엇인가요?");
    public static JTextArea cook_recipe = new JTextArea("레시피를 설명해주세요.");
    public static JButton recipeCommitbutton =  new JButton("작성");

    Map<String,Integer> map = new HashMap();
    ArrayList<Cook> list = new ArrayList<Cook>();

    public WriteMenuPage(){
        setSize(1000,400);
        setLocation(new Point(0,100));
        setBackground(Color.blue);
        setLayout(null);
        addView();
        setVisible(true);
    }

    public void addView() {
        cook_name.setText("요리의 이름은 무엇인가요?");
        cook_name.setSize(250,35);
        cook_name.setLocation(new Point(380,45));

        cook_recipe.setText("레시피를 설명해주세요.");
        cook_recipe.setSize(250,200);
        cook_recipe.setLocation(new Point(380,100));

        recipeCommitbutton.setText("등록");
        recipeCommitbutton.setSize(100,40);
        recipeCommitbutton.setLocation(new Point(450,310));
        recipeCommitbutton.setBackground(Color.GREEN);


        recipeCommitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String cookname = cook_name.getText();
                String recipe = cook_recipe.getText();
                String username = Login.loginName;

                CookProcess cp = addRecipe(cookname,recipe,username);

                if(cp == CookProcess.SUCCESS){
                    ListPage.is_update = false;
                    System.out.println("요리 등록에 성공했음.");
                    repaint();
                }else{
                    System.out.println("요리 등록에 실패함.");
                }

            }
        });

        add(cook_name);
        add(cook_recipe);
        add(recipeCommitbutton);
    }

    @SneakyThrows
    public CookProcess addRecipe(String cookName, String recipe, String username){

        for(Cook c : list){
            if(c.getCook_name().equals(cookName)){
                new ErrorBox("이미 등록된 요리가 있습니다.",this);
                return CookProcess.FAILED;
            }
        }

        if(cookName.isBlank() | cookName.isBlank() | cookName == null |
                recipe.isBlank() | recipe.isEmpty() | recipe == null){
            new ErrorBox("요리 이름이 빈칸입니다.",this);
            return CookProcess.FAILED;
        }

        if(RecipeMainApplication.is_login == false){
            new ErrorBox("로그인부터 해주세요.",this);
            return CookProcess.FAILED;
        }

        for(String token : recipe.split("#") ) {
            String tagName = "";

                for (char c : token.toCharArray()) {
                    if (c == ' ')
                        break;
                    tagName += c;
                }
                if (!tagName.isBlank() | !tagName.isBlank() | !(tagName == null)) {
                    map.put(tagName, map.getOrDefault(tagName, 0) + 1);
                }

        }

        System.out.println(map);

        Connection connection = new GivenConnect(this).connection;
        String sql = "INSERT INTO COOK VALUES(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1,null);
        statement.setString(2,cookName);
        statement.setString(3,username);
        statement.setString(4,recipe);
        statement.setString(5,null);

        int tmp = statement.executeUpdate();

        sql = "INSERT INTO HASHTAG VALUES(?,?,?)";
        PreparedStatement statement1 = connection.prepareStatement(sql);
        statement1.setString(1,null);
        statement1.setString(3,cookName);

        for(String hashtag : map.keySet()){
            statement1.setString(2,hashtag);
            tmp += statement1.executeUpdate();
        }

        if(tmp != 0) {
            new ErrorBox("요리가 등록되었습니다.",this);
            cook_name.setText("");
            cook_recipe.setText("");
            return CookProcess.SUCCESS;
        }else{
            new ErrorBox("요리가 등록되지 않았습니다.",this);
        }

        return CookProcess.FAILED;
    }



    public static void main(String[] args) {
        new WriteMenuPage();
    }
}
