package code.algorithm.inflearn.chap3.chap3_5;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i + 1;

        int tmp = 0;
        int answer = 0;

        int left = 0;

        for (int right = 0; right < n/2+1; right++) {
            tmp += numbers[right];

            if (tmp == n) answer++;

            while (tmp >= n) {
                tmp -= numbers[left++];
                if (tmp == n) answer++;
            }
        }


        System.out.println(answer);
    }
}
