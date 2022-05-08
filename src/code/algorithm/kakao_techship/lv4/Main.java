package code.algorithm.kakao_techship.lv4;


import java.util.*;

class Node {
    int number;
    boolean is_last;
    LinkedList<Node> childNode = new LinkedList<>();
}

class C {
    Node n;

    LinkedList<Node> childNode = new LinkedList<>();

    void addNode(int n, boolean is_last) {

    }
}

class Solution {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {


        for (int[] p : paths) {
            int start = p[0];
            int end = p[1];
            int cost = p[2];


            if (Arrays.stream(summits).anyMatch(x -> x == cost)) { // 정점일 경우

            } else { //아닐 경우

            }


        }

        return new int[]{0};
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] paths = {
                {1, 2, 3},
                {2, 3, 5},
                {2, 4, 2},
                {2, 5, 4},
                {3, 4, 4},
                {4, 5, 3},
                {4, 6, 1},
                {5, 6, 1}
        };
        int[] gates = {1, 3};
        int[] summits = {5};

        System.out.println(
                new Solution().solution(
                        n, paths, gates, summits
                )
        );
    }
}
