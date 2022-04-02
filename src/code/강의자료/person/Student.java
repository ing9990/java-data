package code.강의자료.person;

import lombok.*;

/**
 * @author TaeWK
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private String name;
    private int age;
    private boolean confirmedCase = false;
    private Gender gender;


    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public boolean is_confirmed_case(Student p){
        return p.confirmedCase == true  ? true : false;
    }

    public boolean is_male(Student p){
        return true;
    }
}
