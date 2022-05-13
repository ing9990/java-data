package code.algorithm.inflearn.chap2.chap2_11;

/**
 * @author Taewoo
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int answer = 0;

        int[] meet_count = new int[k];
        int[][] arr = new int[k][5];

        Arrays.fill(meet_count, 0);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 5; j++) {

            }
        }

    }
}
