package poly.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TaeWK
 */
public class Test {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String userName = "root";
        String password = "1111";

        Connection connection = DriverManager.getConnection(url, userName, password);


    }
}
