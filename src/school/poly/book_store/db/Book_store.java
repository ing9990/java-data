package school.poly.book_store.db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author TaeWK
 */


public class Book_store {

    public static Scanner sc = new Scanner(System.in);


    public static Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "1111";
        String url = "jdbc:mysql://localhost:3306/madang?serverTimezone=Asia/Seoul";

        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }



    public static int printMenuAndScan() {
        System.out.print("\n\n1.도서관리   2.고객관리   3.주문하기   4.종료 |  ");
        return sc.nextInt();
    }

    public static int printMenuAndScan_no_01() {
        System.out.print("\n\n1.도서추가   2.수정(가격수정)   3.삭제  4.전체리스트  5.이전으로  | ");
        return sc.nextInt();
    }

    public static int printMenuAndScan_no_02(){
        System.out.print("\n\n1.회원가입   2.전화번호 수정   3.삭제   4.회원목록   5.이전으로  | ");
        return sc.nextInt();
    }

    private static int printMenuAndScan_no_03() {
        System.out.print("\n\n1.주문하기  2.주문수정   3.주문 취소    4.나의 주문보기  5.모든 주문보기  6.이전으로  |  ");
        return sc.nextInt();
    }




    public static void insert() throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\nID 책이름 작가 가격");

        String dat = scan.nextLine();


        String[] datArr = dat.split(" ");

        String sql = "INSERT INTO BOOK VALUES (?,?,?,?)";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setInt(1,Integer.parseInt(datArr[0]));
        statement.setString(2,datArr[1]);
        statement.setString(3,datArr[2]);
        statement.setInt(4,Integer.parseInt(datArr[3]));

        for(String s: datArr)
            System.out.println(s);

        int rst = statement.executeUpdate();
        System.out.println(rst != 0 ? "실행 완료" : "실패");
    }

    public static void update() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n책 이름");
        String data = scanner.nextLine();

        System.out.println("바꿀 가격");
        int price = scanner.nextInt();

        String sql = "UPDATE BOOK SET PRICE=? WHERE BOOKNAME=?";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setInt(1, price);
        statement.setString(2, data);

        int rst = statement.executeUpdate();
        System.out.println(rst != 0 ? "실행 완료" : "실패");

    }

    public static void delete() throws SQLException, ClassNotFoundException {
        System.out.println("\n\n책 아이디를 입력하세요.");
        String bookname = sc.next();

        String sql = "DELETE FROM BOOK WHERE bookid=?";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setString(1,bookname);

        int rst = statement.executeUpdate();
        System.out.println(rst != 0 ? "실행 완료" : "실패");
    }

    public static void printList() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM BOOK";

        Statement statement = makeConnection().createStatement();

        ResultSet set = statement.executeQuery(sql);

        while(set.next()){
            System.out.print("book_id:" + set.getInt("bookid") + "\t");
            System.out.print("book_name:" + set.getString("bookname") +"\t");
            System.out.print("publisher:" + set.getString("publisher") +"\t");
            System.out.println("price:" + set.getString("price") +"\t");
        }
    }






    public static void run() throws SQLException, ClassNotFoundException {
        while (true) {

            int menu_01 = printMenuAndScan();

            
            if(menu_01 == 1){

                int menu_02 = printMenuAndScan_no_01();

                switch (menu_02){
                    case 1:
                        insert();
                        break;
                    case 2:
                        update();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        printList();
                        break;
                    default:
                        break;
                }

            }else if(menu_01 == 2){

                int menu_02 = printMenuAndScan_no_02();

                switch (menu_02){
                    case 1:
                        customerInsert();
                        break;
                    case 2:
                        customerUpdate();
                        break;
                    case 3:
                        customerDelete();
                        break;
                    case 4:
                        customerList();
                        break;
                    default:
                        break;
                }
                
            }else if(menu_01 == 3){
                
                int menu_02 = printMenuAndScan_no_03();
                System.out.print("\n\n1.주문하기  2.주문수정   3.주문 취소    4.나의 주문보기  5.모든 주문보기  6.이전으로");
                switch (menu_02){
                    case 1:
                        ordersInsert();
                        break;
                    case 2:
                        ordersUpdate();
                        break;
                    case 3:
                        ordersDelete();
                        break;
                    case 4:
                        myOrdersSelect();
                        break;
                    case 5:
                        allOrdersSelect();
                        break;
                    case 6:
                        break;


                }




                
            }else if(menu_01 == 4){
                System.out.println("종료");
                return;
            }
            


        }


    }

    private static void allOrdersSelect() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM ORDERS";

        Statement statement = makeConnection().createStatement();

        ResultSet set = statement.executeQuery(sql);

        while(set.next()){
            System.out.print("주문번호:" + set.getInt("orderid") + "\t");
            System.out.print("회원번호:" + set.getString("custid") +"\t");
            System.out.print("상품번호:" + set.getString("bookid") +"\t");
            System.out.println("주문 날짜:" + set.getString("orderdate") +"\t");
        }
    }

    private static void myOrdersSelect() throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n\n회원 번호:  ");
        int id = scan.nextInt();

        String sql = "SELECT * FROM ORDERS WHERE CUSTID=?";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setInt(1,id);

        ResultSet set = statement.executeQuery();


        System.out.println( id + "번 회원님의 주문 내역입니다.");
        while(set.next()){
            
            System.out.print("주문한 상품 번호:" + set.getInt("bookid") + "\t");
            System.out.print("주문한 시간 " + set.getDate("orderdate")+"\n");
        }


    }

    private static void ordersDelete() throws SQLException, ClassNotFoundException {
        allOrdersSelect();

        System.out.print("\n\n위 주문 내역 중 삭제 할 주문번호를 입력하세요:  ");
        int id = sc.nextInt();

        String sql = "DELETE FROM ORDERS WHERE orderid=?";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setInt(1,id);

        int rst = statement.executeUpdate();
        System.out.println(rst != 0 ? id+"번 주문이 취소되었습니다." : "주문 취소를 실패했습니다.");
    }

    private static void ordersUpdate() throws SQLException, ClassNotFoundException {
        allOrdersSelect();

        System.out.print("\n\n위 주문 내역 중 수정 할 주문번호를 입력하세요:  ");
        int id = sc.nextInt();

        System.out.print("상품 번호 입력하세요: ");
        int change_book = sc.nextInt();

        String sql = "UPDATE ORDERS SET BOOKID=? WHERE ORDERID=?";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setInt(1,change_book);
        statement.setInt(2,id);

        int rst = statement.executeUpdate();

        System.out.println(rst != 0 ? id+"번 주문이" + change_book + "+ 상품으로 수정 되었습니다." : "주문 수정을 실패했습니다.");
    }

    private static void ordersInsert() throws SQLException, ClassNotFoundException {
        System.out.print("\n\n주문 번호를 입력하세요:  ");
        int orderid = sc.nextInt();

        System.out.print("주문하는 회원 번호를 입력하세요:  ");
        int customerid = sc.nextInt();

        System.out.print("주문할 상품 번호를 입력하세요:  ");
        int bookid = sc.nextInt();


        String sql = "INSERT INTO ORDERS VALUES(?,?,?,?)";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setInt(1,orderid);
        statement.setInt(2,customerid);
        statement.setInt(3,bookid);

        // SQL에서 YYYY-MM-DD 포맷이길래
        // LocalDateTime으로 파싱하려고 했는데 자꾸 됐다 안됐다 해서 깔끔하게 지웠습니다.
         statement.setDate(4, Date.valueOf(LocalDateTime.now().toLocalDate()) );

        int rst = statement.executeUpdate();

        System.out.println(rst != 0 ?  "주문이 완료되었습니다. 주문번호: " +orderid  : "주문에 실패했습니다.");
    }


    private static void customerList() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM CUSTOMER";

        Statement statement = makeConnection().createStatement();

        ResultSet set = statement.executeQuery(sql);

        while(set.next()){
            System.out.print("회원ID :" + set.getInt("custid") + "\t");
            System.out.print("이름   :" + set.getString("name") +"\t");
            System.out.print("주소   :" + set.getString("address") +"\t");
            System.out.print("전화번호:" + set.getString("phone") +"\n");
        }


    }

    private static void customerDelete() throws SQLException, ClassNotFoundException {
        Scanner me = new Scanner(System.in);

        System.out.print("회원 ID:  ");
        int id = me.nextInt();

        String sql = "DELETE FROM CUSTOMER WHERE CUSTID=?";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        int rst = statement.executeUpdate();

        System.out.println(rst != 0 ? id + "번 회원이 삭제되었습니다." : "삭제를 실패하였습니다.");
    }

    private static void customerUpdate() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);


        System.out.print("회원 명: ");
        String name = scanner.next();

        System.out.print("전화번호: ");
        String phone = scanner.next();


        String sql = "UPDATE CUSTOMER SET PHONE=? WHERE NAME=?";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setString(1, phone);
        statement.setString(2, name);

        int rst = statement.executeUpdate();
        System.out.println(rst != 0 ? name +"님의 전화번호가 " + phone +"으로 변경되었습니다."  : "전화번호 변경 실패.");
    }

    private static void customerInsert() throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("회원 ID:  ");
        int id = scan.nextInt();

        System.out.print("회원 이름:  ");
        String name = scan.next();

        scan.nextLine();

        System.out.print("회원 주소:  ");
        String address = sc.nextLine();

        scan.nextLine();

        System.out.print("전화 번호:  ");
        String phone = scan.next();

        String sql = "INSERT INTO CUSTOMER VALUES (?,?,?,?)";

        PreparedStatement statement = makeConnection().prepareStatement(sql);

        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setString(3,address);
        statement.setString(4,phone);


        int rst = statement.executeUpdate();
        System.out.println(rst != 0 ? name + "님의 정보가 등록되었습니다." : "실패");

    }
}
