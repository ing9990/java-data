package school.poly.과제;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author TaeWK
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static int play() {
        System.out.println("1.등록  2.나이수정  3.삭제  4.전체리스트  5.종료");
        return sc.nextInt();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        boolean flag = true;

        while (flag) {

            StringBuilder sb = new StringBuilder();

            switch (play()) {
                case 1:
                    sb.append("INSERT");
                    PersonDao.run(new PersonDao(sb.toString()));
                    break;

                case 2:
                    sb.append("UPDATE");
                    PersonDao.run(new PersonDao(sb.toString()));
                    break;

                case 3:
                    sb.append("DELETE");
                    PersonDao.run(new PersonDao(sb.toString()));
                    break;

                case 4:
                    sb.append("SELECT");
                    PersonDao.run(new PersonDao(sb.toString()));
                    break;

                case 5:
                    System.out.println("\n\n\n종료");
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못 입력하셨습니다.");
                    System.exit(0);
                    break;
            }


        }

    }
}
