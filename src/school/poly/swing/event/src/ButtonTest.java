package school.poly.swing.event.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author TaeWK
 */

public class ButtonTest extends JFrame {

    public static final String NAME = "김태우";
    JButton button;
    JPanel myPanel;
    JLabel label;

    // Default Constructor
    ButtonTest(){
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
            button = new JButton("Action");
            label = new JLabel("버튼이 아직 눌리지 않았습니다.");

            add(button);
            add(label);

            button.addActionListener(new MyActionListener());
        }

        // ActionListener inner class
        class MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("나는 " + NAME + "라고 해" );

                myPanel.setBackground(Color.YELLOW);
                button.setBackground(Color.RED);

                button.setText(button.getText() == "Action" ? "액션" : "Action");
                label.setText("버튼이 눌렸습니다.");

            }

        }
    }

    // psvm
    public static void main(String[] args) {
        new ButtonColorTest();

    }
}
