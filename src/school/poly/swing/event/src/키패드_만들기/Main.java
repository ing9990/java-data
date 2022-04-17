package school.poly.swing.event.src.키패드_만들기;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author TaeWK
 */
public class Main extends JFrame {

    JFrame frame = new JFrame();

    static JTextField textField = new JTextField();
    static JButton[] buttons = new JButton[12];

    Main(){
        mainFrame();
        setDefault();

        setTf();
        setButtons();

        setVisible(true);
    }

    void setTf() {
        frame.add(textField,BorderLayout.NORTH);
    }

    void setButtons(){
        for(int i = 0 ; i < 12; i++){
            buttons[i] = new JButton();
            buttons[i].setText(String.valueOf(i));
            buttons[i].setBackground(Color.yellow);

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String text = button.getText();
                    textField.setText(textField.getText().concat(text));
                }
            });
            add(buttons[i]);
        }
        pack();
    }


    void setDefault(){
        setSize(800,600);
        setLayout(new GridLayout(3,4,2,2));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void mainFrame(){
        setSize(800,800);
        setLayout(new BorderLayout(2,2));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }
}
