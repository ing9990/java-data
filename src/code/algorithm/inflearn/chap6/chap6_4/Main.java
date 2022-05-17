package code.algorithm.inflearn.chap6.chap6_4;

/**
 * @author Taewoo
 */

import lombok.ToString;

import java.util.*;

public class Main {
    static class Array {

        int[] arr;
        int size;

        public Array(int n) {
            arr = new int[n + 1];
            this.size = n;
            Arrays.fill(arr, 0);
        }

        void push(int v) {
            int i = is_contains(arr, v) == -1 ? arr.length - 1 : is_contains(arr, v);

            for (; i > 0; i--)
                arr[i] = arr[i - 1];

            arr[0] = v;
        }

        int is_contains(int[] arr, int v) {
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == v)
                    return i;
            return -1;
        }

        void printf(int[] arr) {
            for (int item : Arrays.copyOfRange(arr, 0, this.size))
                System.out.print(item + " ");
        }
    }

    public void solution(int n, int[] work) {
        Array array = new Array(n);
        for (int w : work) array.push(w);
        array.printf(array.arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] work = new int[m];

        for (int i = 0; i < m; i++) work[i] = sc.nextInt();

        new Main().solution(n, work);
    }
}
