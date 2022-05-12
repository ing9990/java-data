package code.algorithm.inflearn.chap1.chap1_4;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();


        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder(sc.next());
            System.out.println(sb.reverse());
        }

    }
}
