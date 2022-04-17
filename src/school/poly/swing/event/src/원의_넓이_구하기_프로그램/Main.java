package school.poly.swing.event.src.원의_넓이_구하기_프로그램;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author TaeWK
 */
public class Main extends  JFrame{

    static JLabel label1 = new JLabel("원의 반지름을 작성 후  Enter");
    static JTextField textField = new JTextField();
    static JLabel label2 = new JLabel();


    Main(){
        setDefault();

        label1.setSize(200,100);
        add(label1,BorderLayout.NORTH);



        textField.setSize(200,300);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("key pressesd");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String txt = textField.getText();
                int rad = Integer.parseInt(txt);
                label2.setText(String.valueOf((double)rad * 3.14 * 2));

                Random random = new Random();

                int x = random.nextInt(255) + 1;
                int y = random.nextInt(255) + 1;
                int z = random.nextInt(255) + 1;

                label2.setBackground(new Color(x,y,z));
            }
        });

        add(textField,BorderLayout.CENTER);
        add(label2,BorderLayout.SOUTH);

    }

    void setDefault(){
        setLayout(new BorderLayout(10,10));
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        new Main();
    }
}
