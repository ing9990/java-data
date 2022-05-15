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
        int[][] arr = new int[k + 1][6];

        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < 6; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < k + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < k + 1; j++) {
                for (int l = 1; l < 6; l++) {
                    if (arr[i][l] == arr[j][l]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
