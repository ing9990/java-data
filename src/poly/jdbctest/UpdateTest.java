package poly.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author TaeWK
 */
public class UpdateTest {
    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "1111";
        String url = "jdbc:mysql://localhost:3306/contacts?serverTimezone=Asia/Seoul";

        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 매개변수 2개 주는 삭제
        updateTest("김태우","1234-1234");

        // 객체 형식으로 수정
        updateTest(new Student(50,"윤석열","010-2222-2222"),"문재인");

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 이름:");
        String name = sc.next();

        System.out.print("바꿀 정보 (번호 이름 전화번호) : ");
        String data = sc.next();
        StringTokenizer st = new StringTokenizer(data, " ");

        Student student = new Student(Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken());


        updateTest(student.getName(), student.getTel());
        updateTest(student,name);
    }


    // 해당 이름에 대한 전화번호 변경 매개변수 방식
    public static void updateTest(String name, String tel) throws SQLException, ClassNotFoundException {
        Connection connection = makeConnection();
        String sql = "UPDATE STUDENT SET STUDENT_TEL=? WHERE STUDENT_NAME=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,tel);
        statement.setString(2,name);
    }

    // 해당 이름에 대한 전화번호 변경 객체 방식
    public static void updateTest(Student student, String name) throws SQLException, ClassNotFoundException {
        Connection connection = makeConnection();
        String sql = "UPDATE STUDENT SET STUDENT_TEL=? WHERE STUDENT_NAME=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,student.getTel());
        statement.setString(2,name);

    }

}
