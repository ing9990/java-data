package school.poly.swing.swingHome;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author TaeWK
 */
public class SwingDemoHome3 extends JFrame implements ItemListener {

    JLabel label;

    JPanel panel1, panel2;

    JTextField tf1, tf2;
    JRadioButton rb1, rb2, rb3, rb4;
    ButtonGroup grp;

    public SwingDemoHome3(){

        setTitle("라디오버튼 이벤트2");

        label = new JLabel("");

        tf1 = new JTextField(10);
        tf2 = new JTextField(10);

        rb1 = new JRadioButton("더하기");
        rb2 = new JRadioButton("빼기");
        rb3 = new JRadioButton("곱하기");
        rb4 = new JRadioButton("나누기");

        rb1.addItemListener(this);
        rb2.addItemListener(this);
        rb3.addItemListener(this);
        rb4.addItemListener(this);

        grp = new ButtonGroup();

        grp.add(rb1);
        grp.add(rb2);
        grp.add(rb3);
        grp.add(rb4);

        panel1 = new JPanel();
        panel2 = new JPanel();

        panel1.add(tf1);
        panel1.add(tf2);

        panel2.add(rb1);
        panel2.add(rb2);
        panel2.add(rb3);
        panel2.add(rb4);

        add("North", panel1);
        add("Center", panel2);
        add("South", label);

        setSize(300, 300);
        setVisible(true);

    }

    public void itemStateChanged(ItemEvent e){

        double d1, d2, d3;

        d1 = Double.parseDouble(tf1.getText());
        d2 = Double.parseDouble(tf2.getText());

        if(rb1.isSelected()){
            d3 = d1 + d2;
            label.setText(d1 + "+" + d2 + "=" + d3);
        }

        if(rb2.isSelected()){
            d3 = d1 - d2;
            label.setText(d1 + "-" + d2 + "=" + d3);
        }

        if(rb3.isSelected()){
            d3 = d1 * d2;
            label.setText(d1 + "*" + d2 + "=" + d3);
        }

        if(rb4.isSelected()){
            d3 = d1 / d2;
            label.setText(d1 + "/" + d2 + "=" + d3);
        }

    }

    public static void main(String[] args) {
        new SwingDemoHome3();
    }
}
