package 강의자료.lol;

import lombok.*;

/**
 * @author TaeWK
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Ad extends Champ {

    private String name;

    private int hp;

    private int shieldGauge;

}
