package school.poly.project.pages;

import lombok.SneakyThrows;
import school.poly.project.RecipeMainApplication;
import school.poly.project.messageBox.ErrorBox;
import school.poly.project.sqlUnit.GivenConnect;
import school.poly.project.status.LoginProcess;
import school.poly.project.users.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author TaeWK
 */
public class Login extends JPanel {
    Connection connection = new GivenConnect(this).connection;

    JTextField usernameField = new JTextField();
    JTextField passwordField = new JTextField();

    public static String loginName;

    JButton button = new JButton("로그인");

    ArrayList<Users> list = new ArrayList<Users>();

    public Login() throws SQLException, ClassNotFoundException {
        setSize(1000, 400);
        setLocation(new Point(0, 100));
        setBackground(Color.red);
        this.setLayout(null);
        fi();
        setVisible(true);
    }

    void fi() {
        usernameField.setText("이름을 입력하세요.");
        usernameField.setSize(150, 50);
        usernameField.setLocation(new Point(400, 70));


        passwordField.setText("비밀번호를 입력하세요.");
        passwordField.setSize(150, 50);
        passwordField.setLocation(new Point(400, 160));

        button.setSize(100, 60);
        button.setLocation(420, 250);

        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = usernameField.getText();
                        String password = passwordField.getText();

                        LoginProcess status = userFind(name, password);

                        if(status == LoginProcess.SUCCESS){
                            TopContent.login.setText(loginName+"님");
                            RecipeMainApplication.is_login = true;
                            repaint();
                        }else if( status == LoginProcess.FAILD | status == LoginProcess.ERROR){
                            repaint();
                            return;
                        }
                    }
                }
        );

        add(usernameField);
        add(passwordField);
        add(button);
    }


    @SneakyThrows
    LoginProcess userFind(String name, String password) {

        for (int i = 0; i < list.size(); i++) {
            Users x = list.get(i);

            if (x.getName().equals(name)) {
                if (x.getPassword().equals(password)) {
                    new ErrorBox(x.getName() + "님 반갑습니다.", this);
                    RecipeMainApplication.is_login = true;
                    TopContent.login.setText(x.getName()+"님");
                    loginName = x.getName();
                    RecipeMainApplication.is_login = true;

                    repaint();
                    return LoginProcess.SUCCESS;
                } else {
                    new ErrorBox("비밀번호가 일치하지 않습니다.", this);
                    return LoginProcess.FAILD;
                }
            }
        }

        list.add(new Users(name, password));
        loginName = name;

        String sql = "INSERT INTO USERS VALUES(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, password);

        int result = statement.executeUpdate();

        if (result != 0) {
            new ErrorBox("정상적으로 동록되었습니다.", this);
            this.usernameField.setText("");
            this.passwordField.setText("");
            TopContent.login.setText(name+"님");
            RecipeMainApplication.is_login = true;
            return LoginProcess.SUCCESS;
        } else {
            new ErrorBox("정상적으로 등록되지 않았습니다.", this);
            return LoginProcess.FAILD;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new Login();
    }
}
