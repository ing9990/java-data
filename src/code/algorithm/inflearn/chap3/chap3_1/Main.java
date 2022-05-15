package code.algorithm.inflearn.chap3.chap3_1;

/**
 * @author Taewoo
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++)
            list.add(sc.nextInt());

        int m = sc.nextInt();
        for(int i = 0 ; i < m ; i++)
            list.add(sc.nextInt());

        Collections.sort(list);

        for(int i : list)
            System.out.print(i+ " ");
    }
}
