package code.algorithm.inflearn.chap4.chap4_4;

/**
 * @author Taewoo
 */


import java.util.*;


public class Main {

    public static boolean is_anagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0)
                return false;
            else map.put(c, map.get(c) - 1);
        }
        System.out.println(s1 + " == " + s2);
        return true;
    }

    // map is not contains key -> false;
    // map:key -> values is 0  -> false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int answer = 0;

        int k = s2.length();

        for (int i = 0; i <= s1.length() - k; i++) {
            String tmp = s1.substring(i, i + k);
            if (is_anagram(s2, tmp)) answer++;
        }

        System.out.println(answer);
    }
}


















