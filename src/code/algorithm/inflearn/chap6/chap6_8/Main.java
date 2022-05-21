package code.algorithm.inflearn.chap6.chap6_8;

/**
 * @author Taewoo
 */


import java.util.*;

// binary Search

public class Main {

    public int solution(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (true) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid + 1;

            else if (arr[mid] > target)
                right = mid;
            else if (arr[mid] < target)
                left = mid;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        System.out.println(new Main().solution(arr, target));
    }
}
