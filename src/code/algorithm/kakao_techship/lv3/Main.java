package code.algorithm.kakao_techship.lv3;

import lombok.ToString;

import java.util.*;

// 1. 풀 수 있는 문제 먼저 푼다.
// 2. 실력이 많이 늘 수 있는 문제 먼저 푼다.


@ToString
class Problem {
    int alp_cost;
    int cop_cost;

    int get_alp;
    int get_cop;

    int cost;

    Problem(int[] p) {
        this.alp_cost = p[0];
        this.cop_cost = p[1];
        this.get_alp = p[2];
        this.get_cop = p[3];
        this.cost = p[4];
    }
}


class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int day = 0;
        int min = Integer.MAX_VALUE;


        // 기준 1
        int finalAlp = alp;
        int finalCop = cop;

        Queue<Problem> heap = new PriorityQueue<>(new Comparator<Problem>() {

            @Override
            public int compare(Problem o1, Problem o2) {

                if (finalAlp - o1.alp_cost >= finalCop - o1.cop_cost)
                    if (o1.cost > o2.cost) return 1;
                    else if (o1.cost < o2.cost) return -1;
                    else if (o1.get_alp < o2.get_alp) return 1;
                    else if (o1.get_cop > o2.get_cop) return -1;

                return Integer.compare(o1.cost, o2.cost);
            }
        });

        for (int[] p : problems) {
            heap.offer(new Problem(p));
        }


        for (int i = 0; i < heap.size(); i++) {
            Problem p = heap.poll();

            while (alp >= p.get_alp && cop >= p.get_cop) {
                alp += 1;
                cop += 1;
                day++;
            }

            day += p.cost;
            alp += p.get_alp;
            cop += p.get_cop;

            min = min > day ? day : min;

        }


        for (Problem p : heap)
            System.out.println(p);


        return day;
    }
}

public class Main {
    public static void main(String[] args) {

        int alp = 10;
        int cop = 10;

        int[][] problems = {
                {10, 15, 2, 1, 2},
                {20, 20, 3, 3, 4}
        };
        System.out.println(new Solution().solution(
                alp, cop, problems
        ));
    }
}
