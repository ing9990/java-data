package school.poly.jdbctest;

import java.sql.*;

/**
 * @author TaeWK
 */
public class InsertTest {

    public static void insertStudent(int id,String name, String tel) throws SQLException,ClassNotFoundException{
        Connection connection = makeConnection();

        String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setString(3,tel);


        int rst = statement.executeUpdate(sql);

        System.out.println(rst == 1 ? "추가 성공" : "추가 실패");

        statement.close();
        connection.close();

    }

    public static void insertStudent() throws SQLException, ClassNotFoundException {
        Connection connection = makeConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO STUDENT VALUES(1,'김태우','010-2345-6789')";
        
        int rst = statement.executeUpdate(sql);

        System.out.println(rst == 1 ? "추가 성공" : "추가 실패");

        statement.close();
        connection.close();
    }

    public static void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = makeConnection();

        String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,student.getId());
        statement.setString(2,student.getName());
        statement.setString(3, student.getTel());

        int rst = statement.executeUpdate(sql);

        System.out.println(rst == 1 ? "추가 성공" : "추가 실패");

        statement.close();
        connection.close();
    }

    public static void insertStudentPre(Student student) throws SQLException, ClassNotFoundException {

        Connection connection = makeConnection();

        String sql = "INSERT INTO STUDENT VALUES (?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql.toString());

        statement.setInt(1,student.getId());
        statement.setString(2,student.getName());
        statement.setString(3,student.getTel());

        int rst = statement.executeUpdate();

        System.out.println(rst == 1 ? "추가 성공" : "추가 실패");

        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 매개변수 방식 prep
        insertStudent(52,"하이","2222-2222");
        // 객체 방식 prep
        insertStudentPre(new Student(53,"테스트","3333-3333"));

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
