package code.algorithm.makeWeirdLetters;

/**
 * @author TaeWK
 */


public class Main {

    public static void main(String[] args) {
        String s = "try hello world";
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        System.out.println(answer);
    }
}
