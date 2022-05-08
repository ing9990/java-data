package code.algorithm.kakao_techship.lv1;


import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            map.put(survey[i].charAt(0), 0);
            map.put(survey[i].charAt(1), 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String ques = survey[i];
            int choice = choices[i];

            if (choice <= 3) {
                map.computeIfPresent(ques.charAt(0), (x, y) -> y + 4 - choice);
            } else if (choice >= 5) {
                map.computeIfPresent(ques.charAt(1), (x, y) -> y + choice - 4);
            }
        }

        String answer = "";
        char[][] mbti = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

        for (int i = 0; i < 4; i++) {

            if (!map.containsKey(mbti[i][0])) {
                answer += mbti[i][0];
                continue;
            }

            if (!map.containsKey(mbti[i][1])) {
                answer += mbti[i][1];
                continue;
            }
            int left = map.get(mbti[i][0]);
            int right = map.get(mbti[i][1]);


            if (left > right) {
                answer += mbti[i][0];
            } else if (left < right) {
                answer += mbti[i][1];
            } else {
                answer += mbti[i][0];
            }

        }
        return answer;
    }
}


public class Main {
    public static void main(String[] args) {

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(new Solution().solution(survey, choices));


    }
}
