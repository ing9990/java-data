package code.algorithm.level1.maraton.trie_풀이;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String,Integer> map = new HashMap<>();
        String answer = "";

        for(String s : participant)
            map.put(s,map.getOrDefault(s,0) + 1);

        for(String s : completion)
            map.put(s, map.get(s) - 1);

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
            }
        }

        return answer;
    }
}



public class Main {
    public static void main(String[] args) {
        String[] participant = {
                "leo", "kiki", "eden"
        };

        String[] completion = {
                "eden", "kiki"
        };

        System.out.println(new Solution()
                .solution(participant,completion));
    }
}
