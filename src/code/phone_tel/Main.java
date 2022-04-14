package code.phone_tel;

import java.util.*;

/**
 * @author TaeWK
 */

public class Main {

    public static boolean Solution(String[] phone_book) {

        Arrays.sort(phone_book, Comparator.comparing(String::length).reversed());
        Map<String, Long> map = new LinkedHashMap<>();

        for (String s : phone_book) map.put(s, 1L);

        System.out.println(map);
        return true;
    }

    public static void main(String[] args) {
        String[] s = {"119","97674223","11955224421"};
        System.out.println(Solution(s));
    }
}
