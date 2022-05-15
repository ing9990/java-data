package code.algorithm.grpah.bfs;

/**
 * @author Taewoo
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 양방향 간선의 개수
        int v = sc.nextInt(); // 탐색의 시작점

        boolean visited[] = new boolean[n + 1];
        LinkedList<Integer>[] adj = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++)
            adj[i] = new LinkedList<Integer>();

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            adj[node1].add(node2);
            adj[node2].add(node1);
        }

        for (int i = 1; i <= n; i++)
            Collections.sort(adj[i]);

        bfs_list(v, adj, visited);
    }


    // -- Main
    // 1: visited[] = new boolean[n + 1]
    // 2: LinkedList<Integer>[] adj = new LinkedList[n + 1];
    // 3: adj[1~n] = new LinkedList<Integer>
    // 4: adj input Line[23]~[29]
    // 5: BFS(start, adj, visited)

    // -- BFS [Elements: int startNode, LinkedList<Integer>[] adj, boolean[] visited]
    // 1: make new Queue
    // 2: queue.add(start)
    // 3: visited[start] = true

    // -- Loop Start
    // 4: while(!queue.isEmpty)
    // 5: node = queue.poll
    // 6: print(node) and getAdjList  <- Most Important
    // 7: enqueue to visited[v] = false in adjList
    // -- Loop End


    // ADJ LIST BFS
    private static void bfs_list(int v, LinkedList<Integer>[] adj, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");
            Iterator<Integer> it = adj[v].listIterator();

            while (it.hasNext()) {
                int w = it.next();
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }


}















