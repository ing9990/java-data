package code.algorithm.기능개발;

import java.util.*;

/**
 * @author TaeWK
 */
public class Main {

    public static void main(String[] args) {


        // 정답
        ArrayList<Integer> answer = new ArrayList<>();
        // Map
        Map<Integer, Integer> map = new LinkedHashMap<>();

        // answer = [2,1]
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int tmp = 0;

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int needDay = (100 - progress) % speed == 0 ? ((int) (100 - progress) / speed) : ((int) (100 - progress) / speed) + 1;

            map.put(i, needDay);
        }

        System.out.println("일의 순서=필요한 시간");
        System.out.println(map.entrySet());

        for (int i = 0; i < map.size(); i++) {
            int data = map.get(i);

            for (int j = i + 1; j < map.size(); j++) {
                if (map.get(j) <= data)
                    tmp++;
            }

            answer.add(tmp);
            tmp = 0;
        }

        System.out.println(answer);

    }
}
