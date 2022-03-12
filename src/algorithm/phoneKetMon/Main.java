package algorithm.phoneKetMon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author TaeWK
 */
class Solution{
    public int solution(int[] nums){
        int[] selectNums = new int[nums.length/2];
        ArrayList<Integer> arr = new ArrayList<>();

        Arrays.stream(nums).distinct().forEach(
                (data) ->{
                    arr.add(data);
                }
        );

        arr.forEach(System.out::println);

        if(arr.size() < nums.length/2){
            return arr.size();
        }else if(arr.size() > nums.length/2){
            return nums.length/2;
        }else if(arr.size() == nums.length/2){
            return arr.size();
        }else{
            new RuntimeException("NOT FOUND");
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] nums = {3,1,2,3};

        Solution sol = new Solution();

        System.out.println(sol.solution(nums)+"개");
    }
}
