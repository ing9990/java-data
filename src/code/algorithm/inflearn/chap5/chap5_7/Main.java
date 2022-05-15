package code.algorithm.inflearn.chap5.chap5_7;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {

    public String solution(String s, String token) {
        Queue<Character> queue = new ArrayDeque<>();

        for (char c : token.toCharArray())
            queue.offer(c);

        for(int i = 0 ; i < s.length(); i++){
            if(!queue.isEmpty() && queue.peek() == s.charAt(i))
                queue.poll();
        }

        return queue.size() == 0 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String token = sc.next();
        String s = sc.next();

        System.out.println(new Main().solution(s, token));
    }
}
