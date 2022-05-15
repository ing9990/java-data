package code.algorithm.inflearn.chap3.chap3_6;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int left = 0;   // left pointer
        int cnt = 0;    // 0 -> 1 count
        int answer = 0; // max length

        for (int right = 0; right < n; right++) {

            if (arr[right] == 0) cnt++;      // 0 허용.

            while (cnt > k) {                // 0 허용 횟수가 k보다 작을때까지 반복.
                if (arr[left] == 0) cnt--;   // 0이 나오면 cnt를 빼주고.
                left++;                      // left pointer의 위치를 증가.
            }

            answer = Math.max(answer, right - left + 1);    // 원래의 길이와 현재 길이 비교.
        }

        System.out.println(answer);

    }
}
