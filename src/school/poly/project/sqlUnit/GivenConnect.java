package school.poly.project.sqlUnit;

import school.poly.project.exceptions.DataBaseNotFoundException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TaeWK
 */
public class GivenConnect{

    public static Connection connection;
    public JPanel usingPanel ;

    public GivenConnect() throws SQLException, ClassNotFoundException {
        connection = this.connection == null ? getConnect() : connection;
    }

    public GivenConnect(JPanel panel) throws SQLException, ClassNotFoundException {
        connection = this.connection == null ? getConnect() : connection;
        this.usingPanel = panel;
    }


    protected Connection getConnect() throws ClassNotFoundException, SQLException {
        Connection connection = null;


        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String password = "1111";
        String url = "jdbc:mysql://localhost:3306/RECIPE?serverTimezone=Asia/Seoul";

        connection = DriverManager.getConnection(url, username, password);


        if(connection == null)
            new DataBaseNotFoundException(this.usingPanel);

        return connection;
    }

}
