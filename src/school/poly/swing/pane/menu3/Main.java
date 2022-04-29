package school.poly.swing.pane.menu3;

import javax.swing.*;

/**
 * @author TaeWK
 */

public class Main extends JFrame {

    Main(){
        setting();


    }


    void setting(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }



    public static void main(String[] args) {
        new Main();
    }
}
