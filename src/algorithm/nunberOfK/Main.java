package algorithm.nunberOfK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] rst = new int[command.length];

        for(int i = 0; i<command.length; i++){

            int start = command[i][0];
            int end = command[i][1];
            int k = command[i][2];

            List<Integer> list = new ArrayList<>();

            for(int j = start; j < end+1; j++)
                list.add(array[j-1]);

            Collections.sort(list);
            System.out.println(list);

            rst[i] = list.get(k-1);

        }
        for(int ans : rst)
            System.out.println(ans);
    }
}
