package code.coding_test.단지_번호_붙이기;

/**
 * @author TaeWK
 */


public class Main {

    static int size = 7;

    static int[][] graph = {
            {0, 1, 1, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 0}
    };

    static boolean[][] visited = new boolean[7][7];

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static int dfs(int x, int y){

        if(visited[x][y] == true) return 0;

        if(x < 0 | x > size | y < 0 | y > size) return -1;

        int cnt = 1;

        visited[x][y] = true;


        for(int i = 0 ; i < 4; i++){
            int X = x + dx[i];
            int Y = y + dy[i];

            int rst = dfs(X,Y);
        }

        return 0;

    }

    public static void main(String[] args) {


        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                    dfs(i,j);
            }
        }

    }
}
