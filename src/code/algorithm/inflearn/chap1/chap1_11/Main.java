package code.algorithm.inflearn.chap1.chap1_11;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s+= " ";
        String answer = "";

        for (int i = 0; i < s.length()-1; i++) {
            int tmp = 1;
            answer += s.charAt(i);

            while (s.charAt(i) == s.charAt(i + 1)){
                tmp++;
                i++;
            }

            if(tmp != 1){
                answer += tmp;
            }
        }

        System.out.println(answer);
    }
}
