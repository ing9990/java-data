package code.algorithm.inflearn.chap3.chap3_2;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(),0);
        }

        ArrayList<Integer> list = new ArrayList<>();

            int m = sc.nextInt();
            for (int i = 0; i < m; i++){

                int tmp = sc.nextInt();

                if(map.containsKey(tmp)){
                    list.add(tmp);
                }

            }

            Collections.sort(list);

            for(int i : list)
                System.out.print(i + " ");
        }
    }
