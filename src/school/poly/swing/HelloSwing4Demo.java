package school.poly.swing;

import javax.swing.*;

/**
 * @author TaeWK
 */
public class HelloSwing4Demo extends JFrame {

    HelloSwing4Demo(){
        setTitle("안녕 스윙");

        JPanel panel = new JPanel();
        JLabel label = new JLabel("안녕 스윙");
        JButton button = new JButton("버튼");

        panel.add(label);
        panel.add(button);

        add(panel);
    }

    public static void main(String[] args) {
        new HelloSwing4Demo();
    }
}
