package code.algorithm.level3.단속카메라;

import java.util.*;

/**
 * @author TaeWK
 */

class Solution {

    public int solution(int[][] routes) {

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;

        int min = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (min < route[0]) {
                min = route[1];
                ++cnt;
            }
        }

        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] routes = {
                {-20, -15},
                {-14, -5},
                {-18, -13},
                {-5, -3}};

        System.out.println(new Solution().solution(routes));
    }
}
