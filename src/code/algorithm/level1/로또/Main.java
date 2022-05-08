package code.algorithm.level1.로또;

import java.util.Arrays;

/**
 * @author TaeWK
 */

public class Main {
        /*
        1	6개 번호가 모두 일치
        2	5개 번호가 일치
        3	4개 번호가 일치
        4	3개 번호가 일치
        5	2개 번호가 일치
         */


    //[3,5]
    static int[] lottos = {45,4,35,20,3,9};
    static int[] win = {20,9,3,45,4,35};

    public static void main(String[] args) {

        int zero = (int) Arrays.stream(lottos).filter((x) -> x == 0).count();
        int correct = 0;
        
        for(int i = 0 ; i < lottos.length; i++){
            int idx = i;
            if(Arrays.stream(win).anyMatch((x) -> x == lottos[idx])){
                correct ++;
            }
        }

        System.out.println("0이 전부 맞는 숫자라면: " +(correct + (int) zero));
        System.out.println("0이 전부 틀린 숫자라면: " + correct);



        int[] answer =   {(7-(correct +(int)zero)) , 7 - correct} ;

        if(answer[0] == 0) answer[0] = 1;
        if(answer[1] == 7) answer[1] = 6;

        for(int i : answer)
            System.out.print(i +" ");



    }
}
