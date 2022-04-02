package school.poly.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author TaeWK
 */
public class DeleteTest {

    public static void delete(String name) throws SQLException, ClassNotFoundException {
        Connection connection = makeConnection();

        String sql = "DELETE FROM STUDENT WHERE student_name=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,name);

        int rst = statement.executeUpdate();

        System.out.println(rst > 0 ? rst +"개의 학생 데이터가 삭제되었습니다." : "삭제한 데이터가 없습니다.");

    }

    //문법 DELETE FROM 테이블이름 WHERE 필드이름=데이터값

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 이름:");
        String name = sc.next();

        delete(name);

    }

    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "1111";
        String url = "jdbc:mysql://localhost:3306/contacts?serverTimezone=Asia/Seoul";

        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }
}
