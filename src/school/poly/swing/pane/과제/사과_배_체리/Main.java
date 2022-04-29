package school.poly.swing.pane.과제.사과_배_체리;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main extends JFrame {

    private static final int SCREEN_WIDTH = 500;
    private static final int SCREEN_HEIGHT = 200;

    private static JCheckBox apple = new JCheckBox("사과 100원");
    private static JCheckBox pear = new JCheckBox("배 500원");
    private static JCheckBox cherry = new JCheckBox("체리 20,000원");

    private int price = 0;
    private static JLabel label = new JLabel();

    Main() {
        setting();
        setEvent();
        setLabel();
    }

    private void setLabel(){
        label.setText(String.valueOf(price));
    }

    private void setEvent() {

        apple.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                price = e.getStateChange() == ItemEvent.SELECTED ? price +  100 : price - 100;
                label.setText(String.valueOf(price));
            }
        });
        pear.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                price = e.getStateChange() == ItemEvent.SELECTED ? price +  500 : price - 500;
                label.setText(String.valueOf(price));
            }
        });
        cherry.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                price = e.getStateChange() == ItemEvent.SELECTED ? price +  20000 : price - 20000;
                label.setText(String.valueOf(price));
            }
        });

        add(apple);
        add(pear);
        add(cherry);

        setVisible(true);
    }



    private void setting() {
        setTitle("과일 계산하기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        add(label);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }
}
