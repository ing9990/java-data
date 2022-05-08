package code.algorithm.level2.phone_tel.src;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TaeWK
 */

class Solution{

    public boolean solution(String[] phoneBook){
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < phoneBook.length; i++)
            map.put(phoneBook[i],i);

        for(int i = 0 ; i < phoneBook.length; i++){
            for(int j = 0 ; j < phoneBook[i].length(); j++)
                if(map.containsKey(phoneBook[i].substring(0,j)))
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] p = {"119","97674223","1195524421"};
        boolean ans = new Solution().solution(p);
        System.out.println(ans);
    }
}