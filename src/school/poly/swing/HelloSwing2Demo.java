package school.poly.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author TaeWK
 */
public class HelloSwing2Demo extends JFrame {

    HelloSwing2Demo(){
        Container c = this.getContentPane();
        JLabel lbl = new JLabel("홍길동: ");
        c.add(lbl);

        ImageIcon img = new ImageIcon("./images/car.gif");
    }


    public static void main(String[] args) {

    }
}
