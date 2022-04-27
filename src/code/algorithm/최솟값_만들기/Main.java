package code.algorithm.최솟값_만들기;

import java.util.Arrays;

/**
 * @author TaeWK
 */

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;

        for(int i = 0 ; i < A.length; i++)
            sum += A[i] * B[B.length - i - 1];

        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};

        Solution solution = new Solution();

        System.out.println(solution.solution(A,B));
    }
}
