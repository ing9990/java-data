package school.poly.jdbctest;

import java.sql.*;

/**
 * @author TaeWK
 */
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "1111";
        String url = "jdbc:mysql://localhost:3306/contacts?serverTimezone=Asia/Seoul";

        Connection connection = DriverManager.getConnection(url,username,password);




    }
}
