package code.algorithm.inflearn.chap6.chap6_5;

/**
 * @author Taewoo
 */


import java.util.*;

/**
 * Use [Set]
 * 155ms  Win
 * 240ms  Lose
 * 335ms  Lose
 * 872ms  Lose
 * 794ms  Win
 * <br/>
 * Use [Sort]
 * 157ms  Lose
 * 213ms  Win
 * 314ms  Win
 * 847ms  Win
 * 863ms  Lose
 * <br/>
 */


public class Main {

    // Sort
    public char solution2(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return 'D';
        }

        return 'U';
    }

    // Set
    public char solution(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);

        return set.size() == arr.length ? 'U' : 'D';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(new Main().solution2(arr));

    }
}
