package school.poly.swing.project01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TopPanel extends JPanel {

    JButton button1, button2, button3, button4;

    TopPanel() {

        button1 = new JButton("1번");
        button2 = new JButton("2번");
        button3 = new JButton("3번");
        button4 = new JButton("4번");

        button1.addActionListener(new MyActionListener());
        button2.addActionListener(new MyActionListener());
        button3.addActionListener(new MyActionListener());
        button4.addActionListener(new MyActionListener());

        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String s = button.getText();

            MainFrame frame = (MainFrame) button.getTopLevelAncestor();

            if (s.equals("1번"))  frame.viewScreen(frame.screenPanel1);
            else if (s.equals("2번")) frame.viewScreen(frame.screenPanel2);
            else if (s.equals("3번")) frame.viewScreen(frame.screenPanel3);
            else if (s.equals("4번")) System.exit(0);


        }
    }
}
