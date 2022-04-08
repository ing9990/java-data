package school.poly.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author TaeWK
 */
public class HelloSwing1Demo extends JFrame {


    HelloSwing1Demo(){
        this.setTitle("New App");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        Container c = this.getContentPane();

        // button //
        JButton btn1 = new JButton("1번 버튼");
        btn1.setSize(100,30);
        btn1.setLocation(new Point(50,50));

        JButton btn2 = new JButton("2번 버튼");
        btn2.setSize(100,30);
        btn2.setLocation(new Point(50,150));

        JButton btn3 = new JButton("3번 버튼");
        JButton btn4 = new JButton("4번 버튼");
        JButton btn5 = new JButton("5번 버튼");

        c.add(btn1);
        c.add(btn2);
        c.add(btn3);
        c.add(btn4);
        c.add(btn5);


        /*
        this.setLayout(new GridLayout(3,2));
        this.setLayout(new BorderLayout());
        this.add(btn1,BorderLayout.NORTH);
        this.add(btn2,BorderLayout.SOUTH);
        this.add(btn3,BorderLayout.WEST);
        this.add(btn4,BorderLayout.EAST);
        this.add(btn5,BorderLayout.CENTER);*/


        this.setSize(500,300);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new HelloSwing1Demo();
    }

}
