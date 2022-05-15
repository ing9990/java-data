package code.algorithm.inflearn.chap4.chap4_5;

/**
 * @author Taewoo
 */

import java.util.*;

public class Main {

    public int solution(int[] arr, int n, int k) {

        int answer;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int l = j + 1; l < n; l++)
                    treeSet.add(arr[i] + arr[j] + arr[l]);

        int cnt = 0;

        for(int i : treeSet){
            cnt ++;
            if(cnt == k)
                return i;
        }

        return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(new Main().solution(arr, n, k));

    }
}
