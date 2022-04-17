package school.poly.swing.event.src.hello_라벨_움직이기;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * @author TaeWK
 */

public class Main extends JFrame {

    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 1000;

    public static int LABEL_X = 300;
    public static int LABEL_Y = 300;

    static JLabel label = new JLabel("hello");

    Main(){
        swingDefault();
        label.setBounds(LABEL_X,LABEL_Y,SCREEN_WIDTH/2,SCREEN_HEIGHT/2);
        eventDefault();
        add(label);
    }

    void swingDefault(){
        setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    void eventDefault(){

        addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        int key = e.getKeyCode();
                        int x = label.getX();
                        int y = label.getY();

                        System.out.println(key);

                        if(key == VK_LEFT){
                            label.setLocation(x - 10, y);
                        }else if(key == VK_RIGHT){
                            label.setLocation(x + 10, y);
                        }else if(key == VK_UP){
                            label.setLocation(x , y - 10);
                        }else if(key == VK_DOWN){
                            label.setLocation(x , y + 10);
                        }else{
                            System.out.println(key + "는 없는 명령입니다.");
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
    }


    public static void main(String[] args) {
        new Main();
    }
}

