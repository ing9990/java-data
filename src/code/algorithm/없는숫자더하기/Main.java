package code.algorithm.없는숫자더하기;

import java.util.Arrays;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,6,7,8,0};

        System.out.println(45-(Arrays.stream(numbers).reduce(0,(a, b)->  a + b)));


    }
}
