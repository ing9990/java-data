package school.poly.swing.event.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author TaeWK
 */

public class KeyPressColorTest extends JFrame {

    public static int SCREEN_WIDTH = 500;
    public static int SCREEN_HEIGHT = 300;

    JPanel myPanel;
    JTextField tf;

    // Default Constructor
    KeyPressColorTest(){
        this.setTitle("김태우");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        myPanel = new MyPanel();

        add(myPanel);

        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setResizable(true);
        this.setVisible(true);
    }

    // inner class
    class MyPanel extends JPanel{

        MyPanel(){
            tf = new JTextField();
            add(tf);
            tf.addKeyListener(new KeyActionListener());
        }

        // ActionListener inner class
        class KeyActionListener implements KeyListener{

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 112){ // f1
                    myPanel.setBackground(Color.GREEN);

                }else if(e.getKeyCode() == 53){ // %
                    myPanel.setBackground(Color.YELLOW);
                }
                System.out.println(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                SCREEN_WIDTH += 100;
                SCREEN_HEIGHT += 70;
                setVisible(true);
            }
        }
    }

    // psvm
    public static void main(String[] args) {
        new KeyPressColorTest();
    }
}

