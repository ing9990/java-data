package school.poly.project.pages;

import lombok.SneakyThrows;
import school.poly.project.RecipeMainApplication;
import school.poly.swing.project01.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author TaeWK
 */
public class TopContent extends JPanel {

    public static JButton writeMenu = new JButton("메뉴작성");
    public static JButton showList = new JButton("리스트");
    public static JButton login = new JButton("로그인");
    public static JButton exit = new JButton("종료");
    public static JLabel label = new JLabel("JMT 저장소");


    public TopContent() {
        setSize(1000, 100);
        setBackground(Color.white);
        setLocation(new Point(0, 0));
        setLayout(null);
        addButtons();
        setVisible(true);
    }

    void addButtons() {
        writeMenu.setText("메뉴작성");
        writeMenu.setSize(200, 100);
        writeMenu.setLocation(new Point(0, 0));

        showList.setText("리스트");
        showList.setSize(200, 100);
        showList.setLocation(new Point(200, 0));


        login.setText("로그인");
        login.setSize(200, 100);
        login.setLocation(new Point(600, 0));

        exit.setText("종료");
        exit.setSize(200, 100);
        exit.setLocation(new Point(800, 0));

        label.setText("JMT 저장소");
        label.setSize(200, 100);
        label.setForeground(Color.BLACK);
        label.setLocation(new Point(430, 0));
        label.setFont(new Font(
                "a꽃피는봄", Font.BOLD, 30
        ));

        writeMenu.addActionListener(new ButtonAction());
        exit.addActionListener(new ButtonAction());
        showList.addActionListener(new ButtonAction());
        login.addActionListener(new ButtonAction());

        add(writeMenu);
        add(showList);
        add(login);
        add(exit);
        add(label);
    }

    class ButtonAction implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String text = button.getText();

            RecipeMainApplication mainApplication = (RecipeMainApplication) getTopLevelAncestor();

            switch (text) {
                case "메뉴작성":
                    mainApplication.viewScreen(new WriteMenuPage());
                    break;
                case "리스트":
                    mainApplication.viewScreen(new ListPage());
                    break;
                case "로그인":
                    mainApplication.viewScreen(new Login());
                    break;
                case "종료":
                    System.exit(0);
                    break;
                default:
                    System.out.println("?");
            }


        }
    }

    public static void main(String[] args) {
        new TopContent();
    }
}
