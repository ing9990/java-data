package code.algorithm.level1.가운데글자가져오기;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {
        String s = "abcde";

        if(s.length() % 2 == 0) {
            System.out.println(s.charAt(s.length() / 2));
            System.out.println(s.charAt(s.length() / 2 + 1));
        }
        else
            System.out.println(s.charAt(s.length()/2));
    }
}
