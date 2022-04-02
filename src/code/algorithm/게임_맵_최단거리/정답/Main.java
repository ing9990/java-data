package code.algorithm.게임_맵_최단거리.정답;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;


class Solution {

    public static int solution(int[][] maps) {

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        int X = maps[0].length; // 5
        int Y = maps.length;    // 5

        boolean[][] visited = new boolean[Y][X];  // boolean[5][5]
        Queue<Point> q = new LinkedList<Point>();

        int x = 0;
        int y = 0;

        int size = 0;
        int cnt = 0;

        Point p = new Point();
        q.add(new Point(Y-1,X-1));

        // 이 while을 빠져나간다는건
        // 목표지에 도착했거나, 길이 없다.
        while(q.isEmpty()==false) {

            size = q.size();
            cnt++;

            for(int i = 0; i < size; i++)
            {
                p = q.peek();

                x = p.y;
                y = p.x;

                q.remove();

                if(visited[y][x]==true)  continue;

                maps[y][x] = 0;
                visited[y][x] = true;

                if(x==0 && y==0) return cnt;

                if(x-1>-1 && maps[y][x-1] ==1 ) { //왼쪽 한칸
                    q.add(new Point(y,x-1));
                }
                if(x+1<X && maps[y][x+1] ==1 ) { //오른쪽 한칸
                    q.add(new Point(y,x+1));
                }
                if(y-1 > -1 && maps[y-1][x] ==1) { //위쪽 한칸
                    q.add(new Point(y-1,x));
                }
                if(y+1<Y && maps[y+1][x]== 1) { //아래쪽 한칸
                    q.add(new Point(y+1,x));
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        System.out.println(solution(arr));
    }

}