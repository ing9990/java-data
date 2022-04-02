package school.poly.jdbctest;

import java.sql.*;

/**
 * @author TaeWK
 */
public class ShowList {
    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "1111";
        String url = "jdbc:mysql://localhost:3306/contacts?serverTimezone=Asia/Seoul";

        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = makeConnection();

        String sql = "SELECT * FROM STUDENT";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();

        while(rst.next()){
            System.out.print("name:" + rst.getString(1) + "\t");
            System.out.println("phone:" + rst.getString("student_tel"));
        }
    }
}
