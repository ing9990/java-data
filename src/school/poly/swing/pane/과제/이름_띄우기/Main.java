package school.poly.swing.pane.과제.이름_띄우기;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author TaeWK
 */
public class Main extends JFrame {

    private static final int SCREEN_WIDTH = 500;
    private static final int SCREEN_HEIGHT = 300;

    Main() {
        setting();
        setVisible(true);
    }

    void setting() {
        setTitle("클릭으로 이름 라벨 만들기");
        Container c = getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);

        c.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = new JLabel();

                label.setSize(100,30);
                label.setLocation(new Point(e.getX(),e.getY()));
                label.setBackground(Color.red);
                label.setText("김태우");

                c.add(label);
                label.updateUI();
                setVisible(true);
            }


            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        setVisible(true);

    }


    public static void main(String[] args) {
        new Main();
    }
}
