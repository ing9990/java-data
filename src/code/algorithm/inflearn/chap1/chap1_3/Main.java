package code.algorithm.inflearn.chap1.chap1_3;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] token = s.split(" ");
        String answer = "";

        for(String c : token)
            answer = answer.length() < c.length() ? c : answer;

        System.out.println(answer);

    }
}
