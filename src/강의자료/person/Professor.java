package 강의자료.person;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TaeWK
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Professor {

    private String name;
    private int age;
    private Gender gender;
    private List<Student> studentList = new ArrayList<>();

    public Professor(String name,int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void addStudent(Student s){
        this.studentList.add(s);
    }


    public List<Student> getStudentList(){
        return this.studentList;
    }

}
