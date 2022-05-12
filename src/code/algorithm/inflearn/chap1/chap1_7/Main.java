package code.algorithm.inflearn.chap1.chap1_7;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.toLowerCase();

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if(c[i] != c[c.length -1 - i]) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");

    }
}
