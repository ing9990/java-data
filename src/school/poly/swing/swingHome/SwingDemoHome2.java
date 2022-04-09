package school.poly.swing.swingHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author TaeWK
 */

// 피자 주문 프로그램
public class SwingDemoHome2 extends JFrame implements ActionListener {

    JPanel panel;

    JButton button1 = new JButton("불고기 피자");
    JButton button2 = new JButton("고구마 피자");
    JButton button3 = new JButton("치즈 피자");

    int total = 0;

    Label label = new Label("Total: ");
    TextField tf = new TextField("");

    SwingDemoHome2() {

        panel = new JPanel();
        setTitle("피자 주문 프로그램");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 100);
        setResizable(false);

        tf = new TextField("");
        tf.setSize(800, 100);
        tf.setText("메뉴를 선택하세요.");
        
        button1 = new JButton("불고기 피자");
        button2 = new JButton("불고기 피자");
        button3 = new JButton("불고기 피자");

        button1.setSize(200, 100);
        button2.setSize(200, 100);
        button3.setSize(200, 100);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);


        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(label);
        panel.add(tf);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) this.total += 5000;
        else if (e.getSource() == button2) this.total += 6000;
        else if (e.getSource() == button3) this.total += 7000;

        tf.setText(String.valueOf(total) + "원");
    }


    public static void main(String[] args) {
        new SwingDemoHome2();
    }
}
