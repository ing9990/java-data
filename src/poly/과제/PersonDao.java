package poly.과제;

import lombok.*;
import poly.jdbctest.Student;

import java.sql.*;
import java.util.Scanner;

/**
 * @author TaeWK
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDao {

    /*
            원래 하고 싶었던 로직이 있었는데 다음 날 하려고 보니 까먹어서 로직이 좀 이상합니다 ㅠㅠ
            그래도 잘 돌아가요!
     */

    @Setter
    @Getter
    private String query2Me;

    private static final Scanner sc = new Scanner(System.in);
    private static final int PERSON_NAME = 0;
    private static final int PERSON_AGE = 1;

    static Connection connection = null;

    {
        try {
            connection = makeConnection();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void run(PersonDao personDao) throws SQLException, ClassNotFoundException {

        String msg = personDao.query2Me;

        switch (msg) {
            case "INSERT":
                insert();
                break;
            case "DELETE":
                delete();
                break;
            case "SELECT":
                select();
                break;
            case "UPDATE":
                update();
                break;
        }
    }


    private static void insert() throws SQLException {
        try {
            Person person = new Person();
            System.out.print("이름 나이: ");
            String data = sc.nextLine();
            String[] arr = data.split(" ");

            person.setName(arr[PERSON_NAME]);
            person.setAge(Integer.parseInt(arr[PERSON_AGE]));

            String sql = "INSERT INTO PERSON VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());

            int rst = statement.executeUpdate();
            System.out.println(rst == 1 ? "추가 성공" : "추가 실패");

            statement.close();
            connection.close();
        } catch (SQLIntegrityConstraintViolationException SI) {
            System.out.println("이름이 중복됩니다.");
        }
    }


    private static void select() throws SQLException, ClassNotFoundException {
        Connection connection = makeConnection();
        String sql = "SELECT * FROM PERSON";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();
        while (rst.next()) {
            System.out.print("이름:" + rst.getString("person_name") + "\t");
            System.out.println("나이:" + rst.getString("person_age"));
        }
    }

    private static void delete() throws SQLException, ClassNotFoundException { //이름 받아서
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();
        Connection connection = makeConnection();
        String sql = "DELETE FROM PERSON WHERE PERSON_NAME=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        int rst = statement.executeUpdate();
        System.out.println(rst == 1 ? "데이터가 삭제되었습니다." : "삭제한 데이터가 없습니다.");
    }


    private static void update() throws SQLException, ClassNotFoundException {
        Connection connection = makeConnection();
        System.out.print("이름 변경할나이");
        String data = sc.nextLine();
        String[] arr = data.split(" ");

        String sql = "UPDATE PERSON SET PERSON_AGE=? WHERE PERSON_NAME=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, Integer.parseInt(arr[PERSON_AGE]));
        statement.setString(2, arr[PERSON_NAME]);

        int rst = statement.executeUpdate();
        System.out.println(rst > 0 ? "1개 데이터가 수정되었습니다.." : "삭제한 데이터가 없습니다.");
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
