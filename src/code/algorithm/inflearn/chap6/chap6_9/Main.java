package code.algorithm.inflearn.chap6.chap6_9;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {

    public int count(int[] arr, int capacity) {
        // capacity로 arr의 Elements를 담기 위한 DVD의 갯수를 리턴해주는 메서드.
        int cnt = 1; // 적어도 한장 이상이 필요함.
        int sum = 0; // DVD에 담는 곡길이의 합.

        for (int i : arr) {
            if (sum + i > capacity) {
                cnt++;
                sum = i;
            } else sum += i;
        }
        return cnt;
    }

    public int solution(int[] arr, int size) {
        int answer = 0;

        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();

        while (left <= right) {
            int mid = (left + right) / 2;

            if (count(arr, mid) <= size) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int size = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(new Main().solution(arr, size));
    }
}
