package 강의자료.lol;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        Champ yasuo = new Ad("야스오",800,100);
        Champ lux = new Ap("럭스",500,400);

        Skill 최후의섬광 = new Skill("최후의 섬광",100,300);
        Skill 질풍참 = new Skill("질풍참",0,50);

        yasuo.addSkill(질풍참);
        lux.addSkill(최후의섬광);


        Champ.useSkill(lux,최후의섬광,yasuo);
        Champ.useSkill(lux,최후의섬광,yasuo);
        Champ.useSkill(lux,최후의섬광,yasuo);




    }
}
