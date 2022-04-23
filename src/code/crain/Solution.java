package code.crain;

import java.util.ArrayList;

/**
 * @author TaeWK
 */
public class Solution {

    public static int solution(int[][] board, int[] moves) {
        ArrayList<Integer> list = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < moves.length; i++) {
            int item = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {

                if (board[j][item] != 0) {
                    list.add(board[j][item]);
                    board[j][item] = 0;
                    break;
                }
            }

            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) == list.get(j + 1)) {
                    list.remove(j);
                    list.remove(j);
                    answer += 2;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 정답: 4
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }
}
