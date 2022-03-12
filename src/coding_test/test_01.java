package coding_test;

import java.util.Scanner;

/**
 * @author TaeWK
 */

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        boolean flag = true;

        while(flag){
            if(a==b){
                return answer;
            }
            a= a/2 + a%2;
            b= b/2 + b%2;
            answer ++;
        }
        return -1;
    }
}







public class test_01 {

}
