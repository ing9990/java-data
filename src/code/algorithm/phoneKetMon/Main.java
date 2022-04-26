package code.algorithm.phoneKetMon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author TaeWK
 */
class Solution{
    public int solution(int[] nums){
        return Integer.parseInt(String.valueOf(Arrays.stream(nums).distinct().count())) <= nums.length/2 ? Integer.parseInt(String.valueOf(Arrays.stream(nums).distinct().count())) : nums.length/2;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] nums = {3,1,2,3};

        Solution sol = new Solution();

        System.out.println(sol.solution(nums)+"개");
    }
}
