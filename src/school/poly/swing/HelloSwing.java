package school.poly.swing;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author TaeWK
 */
public class HelloSwing {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setVisible(true);
        frame.setResizable(false);
        frame.getDefaultCloseOperation();
        frame.setTitle("SWING");

        frame.setSize(1000,700);
        JLabel label = new JLabel();
        label.setSize(300,200);


        JButton btn = new JButton();
        btn.setText("클릭");


        System.out.println(LocalDateTime.now());


    }
}
