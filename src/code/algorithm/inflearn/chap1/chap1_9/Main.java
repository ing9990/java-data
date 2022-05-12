package code.algorithm.inflearn.chap1.chap1_9;

/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        s = s.replaceAll("[^0-9]","");

        while(s.startsWith("0"))
            s=s.replaceFirst("0","");

        System.out.println(s);
    }
}
