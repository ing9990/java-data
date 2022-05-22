package school.poly.project.pages;

import lombok.SneakyThrows;
import school.poly.project.messageBox.ErrorBox;
import school.poly.project.sqlUnit.GivenConnectMySQL;
import school.poly.project.users.Cook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

public class ListPage extends JPanel {

    Connection connection = new GivenConnectMySQL(this).connection;
    ArrayList<Cook> result = new ArrayList<>();

    JTextArea textArea = new JTextArea();

    JButton button1 = new JButton("해시태그 검색");
    JButton button2 = new JButton("요리이름 검색");
    JButton button3 = new JButton("요리사명 검색");

    DefaultTableModel model;
    JScrollPane jsp;
    JTable table;

    public static boolean is_update = false;

    public ListPage() throws SQLException, ClassNotFoundException {
        defaultSetting();
        getList();
        hashTageSearchBox();
        repaint();
        setVisible(true);
        System.out.println(list);
    }


    void listUpdate() {

    }


    void hashTageSearchBox(){
        textArea.setSize(600,200);
        textArea.setLocation(500,0);

        button1.setSize(130,100);
        button1.setLocation(500,250);

        button2.setSize(130,100);
        button2.setLocation(700,250);

        button3.setSize(130,100);
        button3.setLocation(870,250);

        button1.addActionListener(new ButtonAction());
        button2.addActionListener(new ButtonAction());
        button3.addActionListener(new ButtonAction());

        add(textArea);
        add(button1);
        add(button2);
        add(button3);
    }

    class ButtonAction implements ActionListener{

        String sql = "";
        String area = textArea.getText();

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            if(buttonText.equals("")) hasTageSearch(area);
            else if(buttonText.equals("")) cookNameSearch(area);
            else if(buttonText.equals("")) usernameSearch(area);
        }

        @SneakyThrows
        private void excute(String sql,String txt) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,txt);
            ResultSet set = statement.executeQuery();

            while(set.next()){
                String cook_name = set.getString("cook_name");
                String user_name = set.getString("user_name");
                String cook_recipe = set.getString("cook_recipe");

                

                table.updateUI();
                jsp.updateUI();
            }
        }

        private void usernameSearch(String txt) {
            sql = "SELECT * FROM COOK WHERE USER_NAME = ?";
            excute(sql,txt);
        }

        private void cookNameSearch(String txt) {
            sql = "SELECT * FROM COOK WHERE COOK_NAME = ?";
            excute(sql,txt);
        }

        private void hasTageSearch(String txt) {
            sql = "SELECT * FROM HASHTAG WHERE HASHTAG_NAME = ?";
            excute(sql,txt);
        }

    }


    ArrayList<Cook> list = new ArrayList<>();

    @SneakyThrows
    void getList() {

        String sql = "SELECT * FROM COOK";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            String cook_name = rs.getString("cook_name");
            String cook_recipe = rs.getString("cook_recipe");
            String user_name = rs.getString("user_name");
            list.add(new Cook(cook_name, user_name, cook_recipe));
        }

        String[] header = {"요리 이름", "레시피", "작성자 명"};
        String[][] cells = new String[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            Cook c = list.get(i);

            cells[i][0] = c.getCook_name();
            cells[i][1] = c.getCook_recipe();
            cells[i][2] = c.getUser_name();
        }

        model = new DefaultTableModel(cells,header);
        table = new JTable(model);
        jsp = new JScrollPane(table);

        table.setSize(500,400);
        table.setLocation(new Point(0,0));
        table.setVisible(true);

        jsp.setSize(500,400);
        jsp.setLocation(new Point(0,0));
        jsp.setVisible(true);

        add(table);
        add(jsp);

        table.updateUI();
        jsp.updateUI();
        jsp.repaint();
        jsp.revalidate();
        repaint();
        revalidate();
    }


    private void defaultSetting() {
        setSize(1000, 400);
        setLocation(new Point(0, 100));
        setBackground(Color.red);
        setVisible(true);
        this.setLayout(null);
    }


    @SneakyThrows
    public static void main(String[] args) {
        new ListPage();
    }
}
