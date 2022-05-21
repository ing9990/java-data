package code.algorithm.inflearn.chap6.chap6_7;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public void solution(int[][] arr) {

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        for (int[] ar : arr) {
            System.out.println(ar[0] + " " + ar[1]);
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        new Main().solution(arr);
    }
}
