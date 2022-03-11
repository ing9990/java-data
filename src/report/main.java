package report;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author TaeWK
 */

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        String distinctArr = Arrays.stream(report)
                .distinct().toString();



        return answer;
    }
}


public class main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] answer = solution.solution(id_list,report,k);
        System.out.println(Arrays.toString(answer));
    }

}
