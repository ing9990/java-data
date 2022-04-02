package code.강의자료.drink;

import lombok.*;

/**
 * @author TaeWK
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Drink {

    private String name;

    public String getName(){
        return this.name;
    }

    public static String getDrinkName(){
        // return this.name;
        return "솔의 눈";
    }
//----------------// Main //---------------------//
    public static void main(String[] args) {
        Drink cola = new Drink("콜라");

        System.out.println(cola.getName());
        System.out.println(Drink.getDrinkName());


    }
}
