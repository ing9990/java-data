package code.algorithm.inflearn.chap2.chap2_5;

import java.util.*;

/**
 * @author Taewoo
 */


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int answer = 0;
        int[] board = new int[k + 1];

        for (int i = 2; i < k; i++) {

            if (board[i] == 0) {
                answer++;
                for (int j = i; j <= k; j += i) {
                    board[j] = -1;
                }
            }

        }

        System.out.println(answer);
    }
}
