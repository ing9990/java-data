package code.algorithm.level2.예상대진표;

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

    public int solution2(int n, int a, int b){
        return Integer.toBinaryString((a-1)^(b-1)).length();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8,4,7));

        System.out.println(3^6);
        System.out.println(Integer.toBinaryString(3^6));

    }
}
