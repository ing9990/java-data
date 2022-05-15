package code.algorithm.inflearn.chap5.chap5_2;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public String solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
            if (c == ')') {
                while (true) {
                    char tmp = stack.pop();
                    if (tmp == '(') break;
                }
            }
        }

        String answer = "";

        for (char c : stack)
            answer += c;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Main().solution(sc.next()));
    }
}
