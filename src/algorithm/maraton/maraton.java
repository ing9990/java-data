package algorithm.maraton;

import java.util.Arrays;

/**
 * @author TaeWK
 */
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++)
            if(!participant[i].equals(completion[i]))
                return participant[i];
        return participant[participant.length-1];
    }
}

public class maraton {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution.solution(participant,completion));
    }
}
