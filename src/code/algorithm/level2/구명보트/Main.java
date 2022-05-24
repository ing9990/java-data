package code.algorithm.level2.구명보트;

/**
 * @author Taewoo
 */


import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {

        int day = 0;

        Arrays.sort(people);
        // 50 50 70 80 - 100

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int lt = people[left];
            int rt = people[right];

            if (lt + rt <= limit) {
                left++;
                right--;
                day++;
            } else {
                right--;
                day++;
            }
        }
        return day;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        System.out.println(new Solution().solution(people, limit));
    }
}
