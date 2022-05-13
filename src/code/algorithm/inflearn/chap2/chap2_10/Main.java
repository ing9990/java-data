package code.algorithm.inflearn.chap2.chap2_10;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int[][] graph = new int[k][k];

        int answer = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                boolean flag = true;
                int num = graph[i][j];

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= k | ny >= k | nx < 0 | ny < 0) {
                        continue;
                    }

                    if (num <= graph[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }

        System.out.println(answer);

    }
}
