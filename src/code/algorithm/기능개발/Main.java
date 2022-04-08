package code.algorithm.기능개발;

import java.util.*;

/**
 * @author TaeWK
 */

class Work {

    int progress;
    int speed;

    public Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }

    public void progressing() {
        this.progress += this.speed;
    }
}


public class Main {

    static int[] progresses = {93, 30, 55};
    static int[] speeds = {1, 30, 5};

    public static void main(String[] args) {

        Queue<Work> queue = new ArrayDeque<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Work(progresses[i], speeds[i]));
        }

        int cnt;

        // 93 - 30 - 55
        while (!queue.isEmpty()) {
            cnt = 0;
            while(queue.peek().progress < 100) queue.peek().progressing();
            while(queue.peek().progress >= 100){
                queue.poll();
                cnt ++;
            }
            arr.add(cnt);
        }

        System.out.println(arr);
    }
}
