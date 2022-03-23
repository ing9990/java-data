package 강의자료.person;

import java.util.ArrayList;

/**
 * @author TaeWK
 */

public class Main {
    public static void main(String[] args) {

        Student 주형 = new Student("서주형",29,false,Gender.MALE);
        Student 욱진 = new Student("신욱진",27,false,Gender.MALE);
        Student 승우 = new Student("이승우",25,true,Gender.MALE);

        Professor 순희 = new Professor("신민화",40,Gender.FEMALE);

        순희.addStudent(주형);
        순희.addStudent(욱진);
        순희.addStudent(승우);

        System.out.println("허순희 교수님의 학생들");

        순희.getStudentList().forEach(
                (x) -> System.out.println(x)
        );


        System.out.println("나이가 25보다 많은 학생들");
        순희.getStudentList().stream().filter((x) -> x.getAge() > 25)
                .forEach(
                        (x) -> System.out.println(x)
                );


        String s =  "Hello world";
        String[] arr = s.split(" ");

        for(String k : arr)
            System.out.println(k);

        int i = 0;



    }
}
