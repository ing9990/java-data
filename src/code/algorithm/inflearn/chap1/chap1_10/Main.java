package code.algorithm.inflearn.chap1.chap1_10;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);

        int[] answer = new int[s.length()];

        int p = 1001;
        for (int i = 0; i < answer.length; i++) {
            if (s.charAt(i) == c) p = 0;
            answer[i] = p++;
        }

        p = 1001;
        for (int i = answer.length - 1; i >= 0; i--) {
            if (s.charAt(i) == c) p = 0;
            if (p < answer[i]) answer[i] = p;
            p++;
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
