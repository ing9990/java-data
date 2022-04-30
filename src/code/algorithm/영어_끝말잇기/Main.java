package code.algorithm.영어_끝말잇기;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TaeWK
 */
class Solution {
    public int[] solution(int n, String[] words) {

        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        String start = words[0];
        String last = "a" + start.charAt(0);

        for(int i = 0 ; i < words.length; i++){
            count ++;
            System.out.println("now: " + words[i]);

            if(words[i].charAt(0) != last.charAt(last.length()-1)){
                int[] answer = {n - count % n, count / n + 1};
                System.out.println("count: " +count);
                return answer;
            }

            if(!map.containsKey(words[i])){
                map.put(words[i],0);
            }else{
                int[] answer = {n - count % n ,   count / n };
                System.out.println("count: " +count);
                return answer;
            }

            last = words[i];
        }

        int[] answer = {0,0};
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

        // [번호, 차례]

        int n = 3;
        String[] words = {
                "tank", "kick", "know",
                "wheel", "land", "dream",
                "mother", "robot", "tank"};

        String[] words2 = {
                "hello", "one",
                "even", "never",
                "now", "world",
                "draw"
        };

        Solution solution = new Solution();

        int[] answer = solution.solution(2,words2);

        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
}
