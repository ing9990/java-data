package code.algorithm.level2.뉴스_클러스터링;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TaeWK
 */

class Solution {
    public float solution(String str1, String str2) {

        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for(int i = 0; i  < str1.length()-1; i++) {
            String token = str1.substring(i,i+2);
            if(map1.containsKey(token)) map1.put(token,map1.get(token) + 1);
            else map1.put(str1.substring(i, i + 2), 0);
        }

        for(int i = 0; i  < str2.length()-1; i++) {
            String token = str2.substring(i,i+2);
            if(map2.containsKey(token)) map2.put(token,map2.get(token) + 1);
            else map2.put(str2.substring(i, i + 2), 0);
        }



        float gyo= 0;


        for(String s : map1.keySet()) {
            char[] tmp = s.toCharArray();

            if (map2.keySet().contains(s) && tmp[0] >= 'A' && tmp[0] <='Z' && tmp[1] >= 'A' && tmp[1] <= 'Z') {
                System.out.println(s);
                gyo += 1.0;
            }
        }

        System.out.println(gyo);



        return gyo /  (map1.size() + map2.size() - gyo )  * 65536 ;
    }

    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 = "shake hands";

        Solution solution = new Solution();
        float rst =  solution.solution(str1,str2);

        System.out.println(rst);
    }
}