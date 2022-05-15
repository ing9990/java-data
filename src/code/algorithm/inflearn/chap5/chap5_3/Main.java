package code.algorithm.inflearn.chap5.chap5_3;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public int soluton(int[][] board, int moves[]) {

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                int now = board[i][pos - 1];
                if (now == 0) continue;

                board[i][pos - 1] = 0;

                if (!stack.isEmpty() && stack.peek() == now) {
                    answer += 2;
                    stack.pop();
                } else stack.push(now);

                break;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(new Main().soluton(board, moves));

    }
}
