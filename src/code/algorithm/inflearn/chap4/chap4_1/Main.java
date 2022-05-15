package code.algorithm.inflearn.chap4.chap4_1;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String result = sc.next();

        Map<Character, Integer> map = new HashMap<>();


        for (char c : result.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        char answer = '.';
        int max = Integer.MIN_VALUE;

        for(char key : map.keySet()){
            if(max < map.get(key)){
                max = map.get(key);
                answer = key;
            }
        }


        System.out.println(answer);
    }
}
