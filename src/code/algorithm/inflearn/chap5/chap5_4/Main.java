package code.algorithm.inflearn.chap5.chap5_4;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public int solution(String s) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c))
                stack.push(Integer.parseInt(c + ""));
            else {
                int right = stack.pop();
                int left = stack.pop();
                int tmp = 0;

                if (c == '+') tmp = left + right;
                else if (c == '-') tmp = left - right;
                else if (c == '*') tmp = left * right;
                else if (c == '/') tmp = left / right;

                stack.push(tmp);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(new Main().solution(s));

    }
}
