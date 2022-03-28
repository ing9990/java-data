package report;

import java.util.*;



public class main {
    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] rst = new int[id_list.length];

        Map<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String s : report)
            set.add(s);

        for(String s : set)
            System.out.println(s);

        for(String s : set){
            StringTokenizer st = new StringTokenizer(s," ");
            String a = st.nextToken(); // 신고한 사람
            String b = st.nextToken(); // 신고 당한 사람.


            for(int i = 0;  i < id_list.length; i++){
                if(id_list[i].equals(a)){
                    rst[i]++;
                }
            }
        }

        for(int i : rst)
            System.out.println(i);

    }
}
