package poly.person.arrPerson;

import poly.person.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author TaeWK
 */
public class main {

    public static List<Person> personArrayList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);


    // 메뉴
    public static int msg() {

        System.out.println("1.등록 2.수정 3.리스트 4.종료");

        Scanner sc = new Scanner(System.in);
        int token = sc.nextInt();

        return token;
    }

    // 추가
    public static void newP() {


        try {
            System.out.print("이름: ");
            String name = sc.next();

            System.out.print("나이: ");
            int age = sc.nextInt();

            personArrayList.add(new Person(name, age));
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("재입력");
        }


    }

    // 출력
    public static void printList() {
        // for~each 출력
        for (Person p : personArrayList)
            System.out.println(p.toString());

        // iterator 출력
        /*Iterator<Person> it = personArrayList.iterator();
        while (it.hasNext())
            System.out.println(it.next());*/

    }

    // 수정
    private static void editList() {
        {

            System.out.print("수정하실 이름을 입력해주세요. ");
            String sch = sc.next();

            personArrayList.forEach(
                    (data) -> {
                        if (data.getName().equals(sch)) {
                            System.out.println("수정할 나이를 입력하세요. 현재 나이: [" + data.getAge() + "]: ");
                            int setage = sc.nextInt();
                            data.setAge(setage);
                        }
                    }
            );
        }
    }


    public static void main(String[] args) {
        boolean flag = true;

        while (flag == true) {
            int menu = msg();

            if (menu == 1)
                newP();
            else if (menu == 2)
                editList();
            else if (menu == 3)
                printList();
            else
                flag = false;
        }
    }
}
