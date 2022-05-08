package code.algorithm.kakao_techship.lv2;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int check = 0;

        Queue<Integer> queuea = new ArrayDeque<>();
        Queue<Integer> queueb = new ArrayDeque<>();

        for (int i : queue1) {
            check += i;
            queuea.offer(i);
        }

        for (int i : queue2) {
            check += i;
            queueb.offer(i);
        }

        if(check % 2 == 1) return -1;
        int correct = check /2;



        return -1;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        System.out.println(new Solution().solution(
                queue1, queue2
        ));

    }
}
