package code.algorithm.예산;

import java.util.Arrays;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        int[] dept = {1,3,2,5,4};
        int result = 0;
        int budget = 9;

        Arrays.sort(dept);

        for(int i = 0 ; i < dept.length; i++) {
            if (budget - dept[i] >= 0) {
                budget -= dept[i];
                result ++;
            }
            else
                System.out.println(result);
        }
        System.out.println(result);
    }
}
