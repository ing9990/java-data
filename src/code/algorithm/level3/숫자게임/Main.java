package code.algorithm.level3.숫자게임;


import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Queue<Integer> heap = new PriorityQueue<>();
        Queue<Integer> heap2 = new PriorityQueue<>();

        for (int i : A) heap.offer(i);
        for (int i : B) heap2.offer(i);

        int cnt = 0;


        while (!heap.isEmpty() && !heap2.isEmpty()) {
            int left = heap.poll();
            int right = heap2.poll();

            System.out.println(heap);
            System.out.println(heap2);

            while (left >= right) {

                if (!heap2.isEmpty())
                    right = heap2.poll();
                else
                    return answer;
            }

            answer++;
            System.out.println(left + " " + right);
        }
        return answer - cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] A = {3, 3, 3, 3};
        int[] B = {3, 3, 3, 3};

        System.out.println(new Solution().solution(A, B));
    }
}
