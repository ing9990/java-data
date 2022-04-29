package school.poly.swing.pane.menu;

import javax.swing.*;

/**
 * @author TaeWK
 */

public class Main extends JFrame {

    Main(){
        setDefault();
        menubox();
    }

    void menubox(){
        JMenuBar mb = new JMenuBar();

        JMenu menu1 = new JMenu("file");
        JMenu menu2 = new JMenu("color");

        mb.add(menu1);
        mb.add(menu2);

        this.setJMenuBar(mb);
        this.setVisible(true);
    }

    void setDefault(){
        setSize(500,500);
        setTitle("메뉴 구성하기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }


}
