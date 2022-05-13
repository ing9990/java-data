package code.algorithm.inflearn.chap2.chap2_1;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int tmp = Integer.MIN_VALUE;

        for(int i = 0 ; i < k; i++){
            int num = sc.nextInt();
            if(num > tmp)
                System.out.print(num + " ");
            tmp = num;
        }
    }
}
