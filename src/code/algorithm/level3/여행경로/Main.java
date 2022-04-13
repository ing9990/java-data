package code.algorithm.level3.여행경로;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author TaeWK
 */
public class Main {

    static String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    static String[][] answer = new String [tickets.length + 1][tickets.length + 1];
    static Map<String,String> map = new HashMap<>();
    static Set<String> set = new HashSet<>();

    public static int dfs(String start){
        boolean[] visited = new boolean[tickets.length];


        if(map.values().contains(start)){

        }

        return 0;
    }

    public static void main(String[] args) {

        for(int i = 0; i < tickets.length; i++) {
            set.add(tickets[i][0]);
            map.put(tickets[i][0],tickets[i][1]);
        }


        set.forEach(x -> dfs(x));

    }
}
