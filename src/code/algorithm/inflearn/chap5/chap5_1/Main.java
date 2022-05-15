package code.algorithm.inflearn.chap5.chap5_1;

/**
 * @author Taewoo
 */

import java.util.*;

public class Main {
    public String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == ')' && stack.isEmpty() || stack.pop() != '(')
                return "NO";
        }

        if (stack.isEmpty())
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(new Main().solution(s));

    }
}
