package code.algorithm.inflearn.chap1.chap1_2;
/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String answer = "";

        for(char c : s.toCharArray())
            answer += (int)c >= 97 ? (char) (c-32) : (char) (c + 32);

        System.out.println(answer);
    }
}
