package code.algorithm.kakao_techship.lv5;


class Solution {

    static void printf(int[][] rc) {
        for (int[] r : rc) {
            for (int r1 : r)
                System.out.print(r1 + " ");
            System.out.println();
        }
    }

    static int[][] shift(int[][] rc) {
        int[] tmp = rc[0];
        rc[0] = rc[rc.length - 1];
        for (int i = rc.length - 1; i > 1; i--) {
            rc[i] = tmp;
            tmp = rc[i - 1];
        }
        printf(rc);
        return rc;
    }


    static int[][] rotate(int[][] rc) {
        int next = rc[0][0];

        for (int i = 0; i < rc.length - 1; i++) rc[i][0] = rc[i + 1][0];
        for (int i = 0; i < rc[0].length - 1; i++) rc[rc.length - 1][i] = rc[rc.length - 1][i + 1];
        for (int i = rc.length - 1; i > 0; i--) rc[i][rc[0].length - 1] = rc[i - 1][rc[0].length - 1];
        for (int i = rc[0].length - 1; i > 0; i--) rc[0][i] = rc[0][i - 1];

        rc[0][1] = next;
        printf(rc);

        return rc;
    }

    public int[][] solution(int[][] rc, String[] operations) {

        printf(rc);

        for (String op : operations) {
            System.out.println();

            switch (op) {
                case "Rotate":
                    rc = rotate(rc);
                    break;
                case "ShiftRow":
                    rc = shift(rc);
                    break;
                default:
                    break;
            }
        }

        return rc;
    }
}


public class Main {
    public static void main(String[] args) {
        int[][] rc = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        String[] op = {"Rotate", "ShiftRow"};

        System.out.println(new Solution().solution(
                rc, op
        ));
    }


}
