package algorithm.optional;

import com.mysql.cj.log.Slf4JLogger;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
