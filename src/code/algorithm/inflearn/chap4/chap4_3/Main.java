package code.algorithm.inflearn.chap4.chap4_3;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {

    static Map<Integer, Integer> map = new HashMap<>();

    public static Map<Integer, Integer> insertMap(int v) {
        map.put(v, map.getOrDefault(v, 0) + 1);
        return map;
    }

    public static Map<Integer, Integer> deleteMap(int v) {
        if (map.get(v) == 1) {
            map.remove(v);
            return map;
        }
        map.put(v, map.getOrDefault(v, 0) - 1);

        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int left = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int right = 0; right < n; right++) {

            if (right < k) {
                insertMap(arr[right]);
                continue;
            }

            System.out.print(map.size() + " ");

            deleteMap(arr[left]);
            insertMap(arr[right]);

            left++;
        }
        System.out.print(map.size());
    }
}















