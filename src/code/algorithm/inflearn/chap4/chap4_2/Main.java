package code.algorithm.inflearn.chap4.chap4_2;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    String solution(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();

        for (char c : s1.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);

        for (char c : s2.toCharArray()) {
            if (!map1.containsKey(c) || map1.get(c) == 0)  return "NO";
            map1.put(c, map1.get(c) - 1);
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(
                new Main().solution(s1,s2)
        );

    }
}
