package code.algorithm.inflearn.chap1.chap1_12;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String s = sc.next();

        s = s.replace("#", "1");
        s = s.replace("*", "0");

        String[] let = new String[k];
        Arrays.fill(let, "");

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 7; j++) {
                let[i] += s.charAt( i * 7 + j);
            }
        }

        for (String p : let)
            System.out.print(((char)(Integer.parseInt(p,2))));

    }
}
