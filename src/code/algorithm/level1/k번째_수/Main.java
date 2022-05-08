package code.algorithm.level1.k번째_수;

import java.util.Arrays;

/**
 * @author TaeWK
 */
public class Main {

    static int[] array = {1, 5, 2, 6, 3, 7, 4};
    static int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    public static void main(String[] args) {

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            answer[i] = splitter(array, commands[i][0], commands[i][1], commands[i][2]);
        }
    }

    public static int splitter(int[] array, int start, int end, int k) {
        int[] arr = new int[end - start + 1];

        for (int i = start - 1 ; i < end ; i++) {
            arr[i - start + 1] = array[i];
        }

        if(arr.length != 1) Arrays.sort(arr);

        return arr[k-1];
    }
}
