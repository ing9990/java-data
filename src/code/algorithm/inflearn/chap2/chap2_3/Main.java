package code.algorithm.inflearn.chap2.chap2_3;/**
 * @author TaeWK
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int[][] board = new int[2][k];

        for(int i = 0 ; i < 2; i++){
            for(int j = 0 ; j < k; j++){
                if(i == 0) {
                    board[i][j] = sc.nextInt();
                }
                if(i == 1){
                    int num = sc.nextInt();

                    if(board[0][j] == num){
                        System.out.println("D");
                    }

                    // 가위:1  바위:2  보:3

                    if(board[0][j] == 1){
                        if(num == 3) System.out.println("A");
                        if(num == 2) System.out.println("B");
                    }

                    if(board[0][j] == 2){
                        if(num == 1) System.out.println("A");
                        if(num == 3) System.out.println("B");
                    }

                    if(board[0][j] == 3){
                        if(num == 1) System.out.println("B");
                        if(num == 2) System.out.println("A");
                    }

                }
            }
        }
    }
}
