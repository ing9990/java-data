package code.algorithm.inflearn.chap2.chap2_8;

/**
 * @author Taewoo
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] scores = new int[k];

        for (int i = 0; i < k; i++) {
            scores[i] = sc.nextInt();
        }

        int[] answer = new int[k];
        Arrays.fill(answer,1);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if(scores[i] < scores[j]){
                    answer[i]++;
                }
            }
        }


        for(int i : answer){
            System.out.print(i + " ");
        }


    }
}
