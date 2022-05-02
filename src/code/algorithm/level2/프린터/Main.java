package code.algorithm.level2.프린터;


import java.util.ArrayDeque;
import java.util.Queue;

class El{
    public static int id = 0;

    public int number;
    public int number_id;

    El(int number) {
        id++;
        this.number = number;
        this.number_id  = id;
    }

    public int getNumber(){
        return number;
    }

    public int getNumber_id(){
        return number_id;
    }

}

class Solution {
    public int solution(int[] priorities, int location) {

        int day = 0;

        El target = new El(priorities[location]);

        Queue<El> deque = new ArrayDeque<>();


        for(int i = 0 ; i < priorities.length; i++){
            if(i == location) deque.offer(target);
            else deque.offer(new El(priorities[i]));
        }



        while (!deque.isEmpty()) {
            El left = deque.poll();

            if (deque.stream().allMatch((right) -> right.getNumber() <= left.getNumber())) {
                if (left.getNumber_id() == target.getNumber_id()) {
                    return day + 1;
                } else {
                    day++;
                }
            } else {
                deque.offer(left);
            }

        }
        return day + 1;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] priorties = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int[] priorties2 = {2,1,3,2};
        int location2 = 2;

        System.out.println(new Solution().solution(priorties2, location2));
    }
}
