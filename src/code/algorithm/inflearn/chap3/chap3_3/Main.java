package code.algorithm.inflearn.chap3.chap3_3;

/**
 * @author Taewoo
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int day = sc.nextInt();

        int[] total = new int[n];
        int tmp = 0;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) total[i] = sc.nextInt();

        for (int i = 0; i < day; i++) tmp += total[i];
        answer = tmp;

        for (int i = day; i < n; i++) {
            tmp += (total[i] - total[i - day]);
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
}
