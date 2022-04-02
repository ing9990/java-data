package code.algorithm.optional;

import java.util.Optional;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        Optional<String> name = Optional.empty();

        System.out.println(name
                .orElse("hello,world")
                .toUpperCase()
        );

        Phone p = new Phone("taewoo","1234");

        System.out.println(Phone.getPID());




    }
}
