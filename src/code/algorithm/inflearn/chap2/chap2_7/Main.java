package code.algorithm.inflearn.chap2.chap2_7;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int plus = 1;
        int answer = 0;
        for(int i = 0 ; i < k ; i++){
            int exam = sc.nextInt();

            if(exam == 1){
                answer += plus++;
            }else{
                plus=1;
            }
        }
        System.out.println(answer);
    }
}
