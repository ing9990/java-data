package school.poly.swing.graphic.prac;

/**
 * @author Taewoo
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GraphicsDrawLineMouseEx extends JFrame {

    private MyPanel panel = new MyPanel();

    public GraphicsDrawLineMouseEx() {
        setTitle("Drawing 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 300);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private List<Point> start = new ArrayList<>();
        private List<Point> end = new ArrayList<>();

        public MyPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Point point = e.getPoint();
                    start.add(point);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Point point = e.getPoint();
                    end.add(point);
                    repaint();
                }
            });
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);

            for (int i = 0; i < start.size(); i++) {
                Point p1 = start.get(i);
                Point p2 = end.get(i);

                g.drawLine((int) p1.getX(), (int) p1.getY(),
                        (int) p2.getX(), (int) p2.getY());
            }
        }
    }

    public static void main(String[] args) {
        new GraphicsDrawLineMouseEx();
    }

}
