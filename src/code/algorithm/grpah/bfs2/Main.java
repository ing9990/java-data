package code.algorithm.grpah.bfs2;

/**
 * @author Taewoo
 */


import java.util.*;


public class Main {

    static LinkedList<Integer>[] adj;
    static LinkedList<Integer>[] dist;
    static boolean[] visited;

    static class bfs {
        static void offer(int n, int[][] edge) {

            LinkedList<Integer>[] adj = new LinkedList[n + 1];
            dist = new LinkedList[n + 1];
            visited = new boolean[n + 1];

            Arrays.fill(visited, false);


            for (int i = 0; i < edge.length; i++) {
                adj[i + 1] = new LinkedList<>();

                int node1 = edge[i][0];
                int node2 = edge[i][1];

                adj[node1].add(node2);
                adj[node2].add(node1);
            }


        }

        static void start(int start) {
            Queue<Integer> queue = new LinkedList<>();

            int v = start;
            queue.add(v);

            while (!queue.isEmpty()) {

                v = queue.poll();
                System.out.print(v + " ");
                visited[v] = true;

                Iterator<Integer> it = dist[v].listIterator();

                while (it.hasNext()) {
                    int node = it.next();

                    if (!visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                    }
                }
            }


        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드의 갯수
        int m = sc.nextInt(); // 양방향 간선의 갯수
        int start = sc.nextInt(); // 시작할 노드 번호

        int[][] edge = new int[m][2];

        for (int i = 0; i < n; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
        }

        bfs.offer(n, edge);
        bfs.start(start);

    }
}
