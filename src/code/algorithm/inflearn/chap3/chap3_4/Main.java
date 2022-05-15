package code.algorithm.inflearn.chap3.chap3_4;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) arr[i] = sc.nextInt();


        int tmp = 0;
        int answer = 0;

        int left = 0;

        for (int right = 0; right < k; right++) {

            tmp += arr[right];
            if (tmp == target) answer++;

            while (tmp >= target) {
                tmp -= arr[left++];

                if (tmp == target)
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
