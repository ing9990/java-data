package 강의자료.lol;

import lombok.*;

/**
 * @author TaeWK
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Skill {

    private String skillName;

    private int manaNeed;

    private int damage;

}
