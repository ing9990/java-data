package code.stream;

import lombok.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author TaeWK
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class People {

    private String name;
    private int age;
    private int gender;

    public static List<People> getPeopleList(){
        return Arrays.asList(
                new People("홍길동",17,1),
                new People("홍길자",18,2),
                new People("홍길순",15,2),
                new People("홍길철",17,1)
        );
    }
}
