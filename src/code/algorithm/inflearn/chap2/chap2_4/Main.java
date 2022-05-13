package code.algorithm.inflearn.chap2.chap2_4;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int[] answer = new int[k];
        answer[0] = 1;
        answer[1] = 1;

        for(int i = 2; i < k; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }

        System.out.println(answer[k-1]);
    }
}
