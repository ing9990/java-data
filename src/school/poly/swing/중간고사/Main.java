package school.poly.swing.중간고사;

import lombok.SneakyThrows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class Main extends JFrame {

    JTextField idField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField heightField = new JTextField();

    JLabel idLabel = new JLabel("ID: ");
    JLabel nameLabel = new JLabel("이름: ");
    JLabel heightLabel = new JLabel("키: ");

    JTextArea textArea = new JTextArea();

    JButton addButton = new JButton("등록");
    JButton deleteButton = new JButton("삭제");
    JButton exitButton = new JButton("종료");

    static int id = 0;
    static String name = "";
    static int height = 0;


    static Connection makeConnection() throws SQLException {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/middb_a?serverTimezone=Asia/Seoul";
        connection = DriverManager.getConnection(url, "root", "1111");


        return connection;
    }


    void defaultSetting() {
        Container c = getContentPane();
        c.setLayout(null);
        setResizable(false);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void setLabels() {
        idLabel.setLocation(new Point(0, 0));
        nameLabel.setLocation(new Point(0, 40));
        heightLabel.setLocation(new Point(0, 80));

        idLabel.setSize(100, 10);
        nameLabel.setSize(100, 10);
        heightLabel.setSize(100, 10);

        add(idLabel);
        add(nameLabel);
        add(heightLabel);
    }

    void setTextFields() {
        idField.setSize(110, 40);
        nameField.setSize(110, 40);
        heightField.setSize(110, 40);

        idField.setLocation(new Point(250, 0));
        nameField.setLocation(new Point(250, 40));
        heightField.setLocation(new Point(250, 80));

        add(idField);
        add(nameField);
        add(heightField);

    }

    void setTextAreas() {
        textArea.setSize(400, 100);
        textArea.setLocation(new Point(0, 120));

        add(textArea);
    }

    void setButtons() {
        addButton.setSize(60, 30);
        deleteButton.setSize(60, 30);
        exitButton.setSize(60, 30);

        addButton.setLocation(100, 220);
        deleteButton.setLocation(170, 220);
        exitButton.setLocation(240, 220);

        addButton.setText("등록");
        deleteButton.setText("삭제");
        exitButton.setText("종료");

        exitButton.addActionListener(new ActionListener() {

                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             System.out.println("프로그램이 종료됩니다.");
                                             System.exit(0);
                                         }
                                     }
        );


        deleteButton.addActionListener(new ActionListener() {

            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {

                name = nameField.getText();

                String sql = "DELETE FROM CUSTOMER WHERE custname LIKE ?";


                PreparedStatement statement = null;

                statement = makeConnection().prepareStatement(sql);


                statement.setString(1, name);


                int tmp = 0;
                tmp = statement.executeUpdate();

                if (tmp != 0) System.out.println("데이터가 성공적으로 삭제되었습니다.");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {


                id = Integer.parseInt(idField.getText());
                name = nameField.getText();
                height = Integer.parseInt(heightField.getText());

                String sql = "INSERT INTO CUSTOMER VALUES(?,?,?)";

                PreparedStatement statement = makeConnection().prepareStatement(sql);

                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setInt(3, height);

                int tmp = statement.executeUpdate();
                if (tmp != 0) System.out.println("등록이 완료되었습니다.");
                String tmp2 = textArea.getText();
                textArea.setText(tmp2 + "\n" + id + "\t" + name + "\t" + height + "cm" + "\n");
            }
        });


        add(addButton);
        add(deleteButton);
        add(exitButton);
    }


    Main() {
        defaultSetting();
        setLabels();
        setTextFields();
        setTextAreas();
        setButtons();
    }


    public static void main(String[] args) {
        new Main();
    }
}
