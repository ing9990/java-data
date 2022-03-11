package poly.person;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * @author TaeWK
 */
public class main {
    public static void main(String[] args) {
        boolean flag = true;
        Person[] arr = new Person[100];

        int size = 0;

        while(flag == true){

            int menu = msg();

            if(menu == 1){
                Person p = newP();
                arr[size] = p;
                System.out.println("등록 완료.\n\n");
                size ++;
            }else if(menu == 2){
                System.out.println("수정 할 인덱스 번호를 입력하세요");
                edit(arr);
            }else if(menu == 3){
                for(int i = 0; i<size; i++){
                    System.out.println(arr[i].toString());
                }
            }else{
                flag = false;
            }
        }

    }

    public static int msg(){

        System.out.println("1.등록 2.수정 3.리스트 4.종료");

        Scanner sc = new Scanner(System.in);
        int token = sc.nextInt();

        return token;
    }

    public static Person newP(){
        Scanner sc = new Scanner(System.in);
        Person p = new Person();

        System.out.println("이름");
        String name = sc.nextLine();

        System.out.println("나이");
        int age = sc.nextInt();

        p.setName(name);
        p.setAge(age);
        p.setAge(age);
        return p;
    }

    public static Person[] edit(Person[] arr){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        arr[num] =  newP();
        return arr;
    }
}
