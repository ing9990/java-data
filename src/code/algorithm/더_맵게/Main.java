package code.algorithm.더_맵게;

import java.util.*;

/**
 * @author TaeWK
 */
class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int day = 0;

        int next = 0;
        int last = 0;

        for (int i : scoville) pq.offer(i);

        while(pq.peek() <= K){

            if(next == -1) return -1;

            last = pq.poll();
            next = pq.isEmpty() ? -1 : pq.poll();

            pq.offer(last + next * 2);
            day ++ ;
        }

        return day;
    }
}

public class Main {
    public static void main(String[] args) {

        // answer = 2

        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;

        System.out.println(new Solution().solution(scoville,K));
    }
}
