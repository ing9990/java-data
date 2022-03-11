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


    public static int msg(){

        System.out.println("1.등록 2.수정 3.리스트 4.종료");

        Scanner sc = new Scanner(System.in);
        int token = sc.nextInt();

        return token;
    }

    public static Person newP() {
        System.out.print("이름: ");
        String name = sc.nextLine();


        System.out.print("나이: ");
        int age = sc.nextInt();

        return new Person(name, age);
    }

    public static void printList(){
        // for~each 출력
        for(Person p : personArrayList)
            System.out.println(p.toString());

        // iterator 출력
        Iterator<Person> it = personArrayList.iterator();
        while(it.hasNext())
            System.out.println(it.next());

    }

    public static void main(String[] args) {
        boolean flag = true;

        while(flag == true){

            int menu = msg();

            if(menu == 1){
                Person p = newP();
                personArrayList.add(p);
                System.out.println("등록 완료.\n\n");

            }else if(menu == 2){
                System.out.print("수정 할 인덱스 번호를 입력하세요");
                int idx = sc.nextInt();

                System.out.print("이름: ");
                String name = sc.nextLine();

                System.out.print("나이: ");
                int age = sc.nextInt();

                personArrayList.get(idx).setName(name);
                personArrayList.get(idx).setAge(age);

                System.out.println(name + ":" + age +"로 수정이 완료되었습니다.");

            }else if(menu == 3){
                printList();
            }else
                flag = false;
        }
    }
}
