package code.algorithm.조이스틱;

import jdk.swing.interop.SwingInterOpUtils;

/**
 * @author TaeWK **/

public class Main {
    static String name = "JEROEN"; // 56
    // static String name = "JAN"  // 23
    public static void main(String[] args) {

        int current = 'A';
        int answer = 0 ;

        for(int i = 0 ; i < name.length(); i++){

            int min = (int) 10e10;
            char target = name.charAt(i);

            int move1 =  (target - 'A') + 1;
            int move2 =  ('Z' - target) + 1 ;
            int move3 = Math.max(target,current) - Math.min(target,current);

            int[] tmp = {move1, move2, move3};
            for(int item : tmp) if(item < min) min = item;

            System.out.print( (char)current+"="+ (int)current + "->" + (char) target +"=" + (int)target );
            System.out.println();
            System.out.println("A로 들러서 가는 경우: " + move1);
            System.out.println("Z로 들러서 가는 경우: " + move2);
            System.out.println("즉시 가는 경우: " + move3);
            
            answer += min;     // answer += 가장 빠른 경로
            current = target;  // 현재 위치 = 이전 알파벳
            System.out.println("answer: " + answer);
            System.out.println("-----------");
        }
        System.out.println(answer);
    }
}
