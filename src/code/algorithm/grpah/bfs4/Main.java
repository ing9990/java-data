package code.algorithm.grpah.bfs4;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {

    static LinkedList<Integer>[] dist;
    static boolean[] visited;

    public static void bfs(int start, boolean[] visited) {

        System.out.print("\nBFS 인접리스트 탐색 결과: ");

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();
            visited[node] = true;
            System.out.print(node + " ");

            Iterator<Integer> it = dist[node].listIterator();

            while (it.hasNext()) {
                int adj = it.next();
                if (!visited[adj]) {
                    queue.offer(adj);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("노드의 개수: ");
        int n = sc.nextInt(); // 노드
        System.out.print("간선의 개수: ");
        int m = sc.nextInt(); // 간선
        System.out.print("탐색을 시작할 노드: ");
        int v = sc.nextInt(); // 탐색 시작 위치

        visited = new boolean[n + 1];
        dist = new LinkedList[n + 1];

        Arrays.fill(visited, false);

        for (int i = 1; i < n + 1; i++)
            dist[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            dist[node1].add(node2);
            dist[node2].add(node1);
        }
        bfs(v, visited);
    }
}
