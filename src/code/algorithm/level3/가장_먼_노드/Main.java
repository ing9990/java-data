package code.algorithm.level3.가장_먼_노드;

import java.util.*;

/**
 * @author Taewoo
 */

class Solution {

    static ArrayList<Integer>[] graph;

    static boolean[] visit;
    static int[] dist;
    static int max = Integer.MIN_VALUE;

    static void offer(int n, int[][] edge) {

        graph = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];

            graph[x].add(y);
            graph[y].add(x);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        visit[1] = true;
        dist[1] = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (Integer x : graph[node]) {
                if (!visit[x]) {
                    queue.offer(x);
                    visit[x] = true;
                    dist[x] = dist[node] + 1;
                    max = Math.max(max, dist[x]);
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {

        offer(n, edge);
        bfs();

        int answer = 0;

        for (int i : dist)
            if (i == max)
                answer++;

        return answer;
    }

}

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}};

        System.out.println(new Solution().solution(n, vertex));
    }
}
