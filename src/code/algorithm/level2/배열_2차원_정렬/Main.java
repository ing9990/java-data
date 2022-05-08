package code.algorithm.level2.배열_2차원_정렬;

import java.util.Arrays;

/**
 * @author TaeWK
 */
public class Main {

    public static void printf(int[][] graph){
        for(int[] items : graph){
            for (int i : items){
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = {{1,2}, {3,4}, {5,6} , {7,8}};

        Arrays.sort(graph,(o1,o2) -> o2[1] - o1[1] );
        printf(graph);





    }
}
