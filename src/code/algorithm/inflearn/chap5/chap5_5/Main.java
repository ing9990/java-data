package code.algorithm.inflearn.chap5.chap5_5;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public int solution(String s) {

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if (s.charAt(i - 1) == '(') answer += stack.size();
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(new Main().solution(s));
    }
}
