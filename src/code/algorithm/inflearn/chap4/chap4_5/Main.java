package code.algorithm.inflearn.chap4.chap4_5;

/**
 * @author Taewoo
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());

        int tmp = k / n;
        int tmp2 = k % n;

        int first = arr[k / n];
        int second = arr[k % n + tmp];
        int third = arr[second / n + tmp + tmp2];

        System.out.print(first + " ");
        System.out.print(second + " ");
        System.out.print(third + " " + "\n");

        System.out.println(first + second + third);

    }
}
