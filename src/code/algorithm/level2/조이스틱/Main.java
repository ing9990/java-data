package code.algorithm.level2.조이스틱;

/**
 * @author TaeWK
 **/

public class Main {

    //static String name = "JEROEN"; // 56
    static String name = "JAN";    // 23

    public static void main(String[] args) {

        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == 'A') answer --;
            answer += Math.min('Z' - name.charAt(i) + 1, name.charAt(i) - 'A');
        }

        System.out.println(answer + name.length() - 1 );
    }
}
