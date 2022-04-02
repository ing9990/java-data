package code.report;

import java.util.*;


public class main {
    public static void main(String[] args) {



        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi","muzi frodo"};

        Set<String> arr = new HashSet<>();

        for(String s  : reports)
            arr.add(s);

        ArrayList<String> report = new ArrayList<>();
        arr.forEach( x->
                report.add(x)
        );


        int[] reportCnt = new int[id_list.length];
        int[] answer = new int[id_list.length];


        HashMap<String, String> map = new HashMap<>();
        int k = 2;

        for (int i = 0; i < report.size(); i++) {
            String[] tmp = report.get(i).split(" ");
            String reporter = tmp[0];
            String reported = tmp[1];

            for (int j = 0; j < id_list.length; j++) {
                if (id_list[j].equals(reported))
                    reportCnt[j]++;
            }
            map.put(reported, reporter);
        }


        System.out.println("신고당한 횟수");
        for (int i : reportCnt) System.out.print(i + " ");
        System.out.println("\n");

        ArrayList<String> rst = new ArrayList<>();

        for (int i = 0; i < id_list.length; i++) {
            if (reportCnt[i] >= k) {
                rst.add(id_list[i]);
            }
        }

        System.out.println(map.entrySet() + "\n");

        System.out.println("정지 먹은 사람");
        System.out.println(rst);


        for (int i = 0; i < report.size(); i++) {
            String[] tmp = report.get(i).split(" ");

            String reporter = tmp[0];
            String reported = tmp[1];

            if (rst.contains(reported)) {
                int idx = Arrays.asList(id_list).indexOf(reporter);
                answer[idx]++;
            }


        }

        System.out.println("결과");
        for(int i : answer) System.out.print(i);
    }
}
