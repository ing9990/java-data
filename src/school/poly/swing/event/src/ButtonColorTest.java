package school.poly.swing.event.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * @author TaeWK
 */

public class ButtonColorTest extends JFrame {

    JButton buttonY;
    JButton buttonR;

    JPanel myPanel;

    // Default Constructor
    ButtonColorTest(){
        this.setTitle("김태우");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        myPanel = new MyPanel();

        add(myPanel);

        this.setSize(500,300);
        this.setVisible(true);
    }

    // inner class
    class MyPanel extends JPanel{

        MyPanel(){
            buttonY = new JButton("노란색");
            buttonR = new JButton("빨간색");

            add(buttonY);
            add(buttonR);

            buttonY.addActionListener(new MyActionListener());
            buttonR.addActionListener(new MyActionListener());
        }

        // ActionListener inner class
        class MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();

                myPanel.setBackground(
                        button.getText().equals("노란색") ? Color.YELLOW : Color.RED);

            }
        }
    }

    // psvm
    public static void main(String[] args) {
        new ButtonColorTest();

    }
}
