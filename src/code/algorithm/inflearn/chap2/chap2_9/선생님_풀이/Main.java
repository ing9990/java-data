package code.algorithm.inflearn.chap2.chap2_9.선생님_풀이;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {

        int answer = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        int sum1, sum2;
        int n = sc.nextInt();

        int[][] arr = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }

        answer = Math.max(sum1,answer);
        answer = Math.max(sum2,answer);

        System.out.println(answer);
    }
}
