package school.poly.project;


import lombok.SneakyThrows;
import school.poly.project.exceptions.DataBaseNotFoundException;
import school.poly.project.messageBox.ErrorBox;
import school.poly.project.pages.ListPage;
import school.poly.project.pages.Login;
import school.poly.project.pages.TopContent;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class RecipeMainApplication extends JFrame {

    public Container c = getContentPane();

    TopContent topContent = new TopContent();
    Login loginPanel = new Login();
    ListPage listPanel = new ListPage();

    public static boolean is_login = false;
    public static String username = Login.loginName;

    @SneakyThrows
    RecipeMainApplication() throws SQLException, ClassNotFoundException {
        defaultSetting();
        viewScreen(loginPanel);

        while(is_login == true)
            login_check();


        revalidate();
        repaint();

    }


    // --------------- 로그인 확인 영역 ------------------- \\

    void login_check(){
        if(is_login == true){
            TopContent.login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            viewScreen(listPanel);
            repaint();
        }
    }


    public void viewScreen(JPanel panel) {
        c.removeAll();
        c.add(topContent);
        add(panel);
        repaint();
        setVisible(true);
    }

    // ------------- JFrame 기본 설정 영역 --------------------------- \\

    protected void defaultSetting() {
        setSize(1000, 500);
        setResizable(false);
        c.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }





    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new RecipeMainApplication();
    }
}
