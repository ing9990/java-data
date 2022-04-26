package code.algorithm.예상대진표;

/**
 * @author TaeWK
 */

class Solution
{
    static int ans = 0;
    public int solution(int n, int a, int b)
    {
        if(a==b) return ans;
        ans ++;
        return solution(n,a/2 + a%2 , b/2 + b%2);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8,4,7));
    }
}
