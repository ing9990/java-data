package code.강의자료.lol;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TaeWK
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Champ {

    String name;
    int hp;
    List<Skill> skillList = new ArrayList<>();

    public void addSkill(Skill s) {
        this.skillList.add(s);
    }

    public static void useSkill(Champ me, Skill s, Champ c) {

        // -- 마나 부족 처리 -- //
        if (me instanceof Ap)
            if (((Ap) me).getMana() < s.getManaNeed()) {
                System.out.println("마나가 부족합니다.");
                return;
            }

        // -- 피해량 -- //
        int tmp = c.getHp() - s.getDamage();
        c.setHp(tmp);

        // -- 처치 -- //
        System.out.println(tmp <= 0 ? me.getName() + "님이 " + c.getName() + "를 처치하였습니다." : me.getName() +"님이 "+c.getName()+"님 에게" +
                s.getDamage()+"의 피해를 입혔습니다.\n" + c.getName() +"의 남은 체력["+c.getHp()+"]");
    }
}