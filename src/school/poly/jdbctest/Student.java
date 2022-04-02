package school.poly.jdbctest;

import lombok.*;

/**
 * @author TaeWK
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private int id;
    private String name;
    private String tel;
}
