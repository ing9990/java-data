package code.algorithm.level4.노래_가사;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int[] solution(String[] words, String[] queries) {

        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Character> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i],null);
        }


        for(int i = 0 ; i < queries.length; i++){

            String token = queries[i];

            int length = token.length();
            AtomicInteger tmp = new AtomicInteger();
            StringBuilder sb = new StringBuilder();

            for(char c : token.toCharArray())
                if (c != '?') sb.append(c);


            if(token.charAt(0) == '?'){

                map.forEach( (x,y) -> {
                    if(x.length() == length && x.endsWith(sb.toString())){
                        tmp.getAndIncrement();
                    }
                });

            }else{
                map.forEach( (x,y) -> {
                    if(x.length() == length && x.startsWith(sb.toString())){
                        tmp.getAndIncrement();
                    }
                });

            }
            answer.add(tmp.get());
        }



        int[] result = answer.stream()
                .filter(i -> i != null)
                .mapToInt(i -> i)
                .toArray();

        return result;
    }
}


public class Main {
    public static void main(String[] args) {

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] result = new Solution().solution(
                words, queries
        );

        for(int i : result) System.out.print(i + "");


    }
}
