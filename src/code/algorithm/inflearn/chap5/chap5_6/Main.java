package code.algorithm.inflearn.chap5.chap5_6;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public int solution(int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++)
            queue.offer(i);

        int cnt = 1;

        while (queue.size() != 1) {
            cnt++;
            queue.offer(queue.poll());
            if (cnt == k) {
                queue.poll();
                cnt = 1;
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(new Main().solution(n, k));
    }
}
