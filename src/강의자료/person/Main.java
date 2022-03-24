package 강의자료.person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TaeWK
 */

public class Main {
    public static void main(String[] args) {

        Student 주형 = new Student("서주형",29,false,Gender.MALE);
        Student 욱진 = new Student("신욱진",27,false,Gender.MALE);
        Student 승우 = new Student("김승우",25,true,Gender.FEMALE);
        Student 태우 = new Student("김태우",20,true,Gender.FEMALE);

        Professor 순희 = new Professor("허순희",40,Gender.FEMALE);

        순희.addStudent(주형);
        순희.addStudent(욱진);
        순희.addStudent(승우);
        순희.addStudent(태우);

        System.out.println("허순희 교수님의 학생들");

        순희.getStudentList().forEach(
                (x) -> System.out.println(x)
        );


        System.out.println("나이가 25보다 많은 학생들");
        순희.getStudentList().stream().filter((x) -> x.getAge() > 25)
                .forEach(
                        (x) -> System.out.println(x)
                );

        System.out.println("이름이 김씨인 사람");
        순희.getStudentList().stream().filter((x) ->x.getName().charAt(0)=='김')
                .forEach(System.out::println);

        순희.getStudentList().remove(2);

        System.out.println("허순희 교수님의 학생들");

        순희.getStudentList().forEach(
                (x) -> System.out.println(x)
        );

        순희.getStudentList().sort(Comparator.comparing(Student::getAge));

        System.out.println("허순희 교수님의 학생들");

        순희.getStudentList().forEach(
                (x) -> System.out.println(x)
        );

        Integer b = 0;
        Integer a = 2;

        System.out.println(a+b);



        Map<String,Integer> map = new HashMap<>();
        map.put("김태우",20);
        map.put("나영환",21);

        map.forEach((x,y) -> System.out.println(x+y));

        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map.containsValue(20));
        System.out.println(map.containsKey("김태우"));

        System.out.println(map.entrySet());

    }
}
