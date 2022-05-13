package code.algorithm.inflearn.chap2.chap2_2;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int tmp = Integer.MIN_VALUE;
        int answer = 0;

        for(int i = 0; i < k; i++){
            int height = sc.nextInt();
            if(tmp < height) {
                answer++;
                tmp = height;
            }
        }
        System.out.println(answer);
    }
}
