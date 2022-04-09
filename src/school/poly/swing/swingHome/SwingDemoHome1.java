package school.poly.swing.swingHome;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author TaeWK
 */

// 0 ~ 30사이 난수를 발생시켜서 임의 위치에 배치하기.

public class SwingDemoHome1 extends JFrame {
    SwingDemoHome1() throws InterruptedException {

        setTitle("난수 발생");
        Random random = new Random();


        Container c = getContentPane();
        c.setLayout(null);
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextField tf = new JTextField("");
        for(int i = 0 ; i < 30; i++) {
            tf.setText(i+"");
            tf.setSize(50,50);
            int num = random.nextInt(30);

            int width = random.nextInt(800);
            int height = random.nextInt(500);

            Label label = new Label();
            label.setText(String.valueOf(num));
            label.setBackground(Color.YELLOW);

            label.setLocation(new Point(width,height));
            c.add(tf);
            c.add(label);
            label.setSize(50,50);

            Thread.sleep(300);

            setVisible(true);
        }
    }


    public static void main(String[] args) throws InterruptedException {
            new SwingDemoHome1();
    }
}
