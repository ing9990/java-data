package school.poly.swing.pane.menu2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame {
    JLabel dogImage = new JLabel();
    ImageIcon img = new ImageIcon("C:\\projects\\coding-test-java\\src\\school\\poly\\swing\\pane\\menu2\\img.jpg");

    Main() {
        menu_setting();
        getContentPane().add(dogImage, BorderLayout.CENTER);
        setSize(800,500);
        setVisible(true);
    }


    void menu_setting() {

        JMenuBar my_menubar = new JMenuBar();

        JMenuItem [] menuItems = new JMenuItem [4];

        String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};

        JMenu screenMenu = new JMenu("Screen");

        MenuActionListener listener = new MenuActionListener();

        for(int i=0; i<menuItems.length; i++) {
            menuItems[i] = new JMenuItem(itemTitle[i]);
            menuItems[i].addActionListener(listener);
            screenMenu.add(menuItems[i]);
        }

        my_menubar.add(screenMenu);
        setJMenuBar(my_menubar);

    }
    class MenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String my_listen = e.getActionCommand();

            switch(my_listen) {
                case "Load" :
                    if(dogImage.getIcon() != null)
                        return;
                    dogImage.setIcon(img);
                    break;
                case "Hide" :
                    dogImage.setVisible(false);
                    break;
                case "ReShow" :
                    dogImage.setVisible(true);
                    break;
                case "Exit" :
                    System.exit(0);
                    break;

            }
        }
    }

    public static void main(String [] args) {
        new Main();
    }
}