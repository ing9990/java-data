package code.algorithm.inflearn.chap2.chap2_5;

import java.util.*;

/**
 * @author Taewoo
 */


public class Main {

    public void solution(int k, int[] board) {
        int answer = 0;

        for (int i = 2; i < k; i++) {

            if (board[i] == 0) {
                answer++;
                for (int j = i; j <= k; j += i) {
                    board[j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int[] board = new int[k + 1];

        new Main().solution(k, board);
    }
}
