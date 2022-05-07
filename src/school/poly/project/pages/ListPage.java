package school.poly.project.pages;

import javax.swing.*;
import java.awt.*;

public class ListPage extends JPanel {

    public ListPage(){
        setSize(1000,400);
        setLocation(new Point(0,100));
        setBackground(Color.green);
        this.setLayout(null);
        setVisible(true);
        addList();
        repaint();
        revalidate();
    }

    public  void addList() {
        String sql = "";

    }


    public static void main(String[] args) {
        new ListPage();
    }
}
