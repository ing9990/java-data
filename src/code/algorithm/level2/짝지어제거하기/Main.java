package code.algorithm.level2.짝지어제거하기;

import java.util.Stack;

/**
 * @author TaeWK
 */
public class Main {

    static String s = "baabaa";


    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
            System.out.println(stack);
        }

    }
}
