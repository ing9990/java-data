package code.algorithm.inflearn.chap6.chap6_6;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public void solution(int[] arr) {
        int[] arr2 = Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                int answer = i + 1;
                System.out.print(answer + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        new Main().solution(arr);
    }
}
