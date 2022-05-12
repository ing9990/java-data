package code.algorithm.inflearn.chap1.chap1_5;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int left = 0;
        int right = str.length() - 1;
        char[] c = str.toCharArray();

        while (left < right) {
            if (!Character.isAlphabetic(c[left])) left++;
            else if (!Character.isAlphabetic(c[right])) right--;
            else {
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
                left++;
                right--;
            }
        }
        System.out.println(String.valueOf(c));
    }
}