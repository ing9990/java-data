package code.algorithm.inflearn.chap2.chap2_9;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int[][] board = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int answer = Integer.MIN_VALUE;


        // 가로 줄
        for(int i = 0 ; i < k ; i++){
            int tmp = 0;
            for(int j = 0; j<k; j++){
                tmp += board[i][j];
            }
            answer = Math.max(answer,tmp);
        }

        // 세로 줄
        for(int i = 0 ; i < k ; i++){
            int tmp = 0;
            for(int j = 0; j<k; j++){
                tmp += board[j][i];
            }
            answer = Math.max(answer,tmp);
        }

        // 대각선 좌우
        int tmp = 0;

        for(int i = 0, j= 0 ; i < 5; i++,j++){
            tmp += board[i][j];
        }

        answer = Math.max(answer,tmp);

        tmp = 0;
        // 대각선 우좌
        for(int i = k-1, j= k-1 ; i > 5; i--,j--){
            tmp += board[i][j];
        }
        answer = Math.max(answer,tmp);

        System.out.println(answer);
    }
}
