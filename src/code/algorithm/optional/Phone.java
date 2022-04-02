package code.algorithm.optional;

import lombok.*;

/**
 * @author TaeWK
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Phone {

    private static final Long PHONE_DATE_LONG = 20200324L;

    private String username;
    private String password;

    public static Long getPID(){
        return PHONE_DATE_LONG;
    }

}
