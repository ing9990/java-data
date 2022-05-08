package code.algorithm.level2.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {

            int progress = progresses[i];
            int speed = speeds[i];
            int remain = 100 - progress;

            queue.offer(remain % speed == 0 ? remain / speed : remain / speed + 1);
        }

        while (!queue.isEmpty()) {

            int top = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && queue.peek() <= top) {
                queue.poll();
                cnt++;
            }
            list.add(cnt);
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}

public class Main {
    static int[] progresses = {93, 30, 55};
    static int[] speeds = {1, 30, 5};

    public static void main(String[] args) {
        System.out.println(new Solution().solution(progresses, speeds));
    }
}

