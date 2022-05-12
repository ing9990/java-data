package code.algorithm.inflearn.chap1.chap1_8;

/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(s).reverse().toString();
        System.out.println(tmp.equals(s)?"YES":"NO");
    }
}
