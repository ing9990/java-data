package code.algorithm.grpah.bfs3;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    static void bfs(int start, LinkedList<Integer>[] adj, boolean[] visited) {

        System.out.print("\nBFS 인접리스트 탐색: ");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            Iterator<Integer> it = adj[node].listIterator();

            while (it.hasNext()) {
                int next = it.next();
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of node: ");
        int n = sc.nextInt(); // number of node
        System.out.print("\nNumber of Line: ");
        int m = sc.nextInt(); // number of edge
        System.out.print("\nStart Node: ");
        int start = sc.nextInt(); //start node

        boolean[] visited = new boolean[n + 1];
        LinkedList<Integer>[] adj = new LinkedList[n + 1];
        Arrays.fill(visited, false);


        for (int i = 1; i <= n; i++) adj[i] = new LinkedList<>();

        // Input Edge
        for (int i = 0; i < m; i++) {
            System.out.print("\nLine" + (i + 1) + ": ");
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            adj[node1].add(node2);
            adj[node2].add(node1);
        }

        bfs(start, adj, visited);
    }
}
