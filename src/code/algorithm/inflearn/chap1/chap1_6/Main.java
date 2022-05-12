package code.algorithm.inflearn.chap1.chap1_6;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String answer = "";

        for (int i = 0; i < s.length(); i++)
            if(s.indexOf(s.charAt(i)) == i)
                answer += s.charAt(i);

        System.out.println(answer);
    }
}
