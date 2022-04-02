package code.openChat;

import java.util.*;


/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        int cnt = 0;

        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        for(int i = 0 ; i < record.length; i++){

            String[] msg = record[i].split(" ");

            String move = msg[0];
            String uid = msg[1];

            String name = "";
            if(!msg[0].equals("Leave")){
                name = msg[2];
            }

            if(move.equals("Enter")){
                map.put(uid,name);
            }else if(move.equals("Leave")){

            }else if(move.equals("Change")){
                map.put(uid,name);
                cnt++;
            }
        }

        String[] rst = new String[record.length-cnt];

        for(int i=0; i < record.length; i++){
            String[] msg = record[i].split(" ");

            String move = msg[0];
            String uid = msg[1];
            String name = "";

            if(!msg[0].equals("Leave")){
                name = msg[2];
            }

            if(move.equals("Enter")){
                rst[i] = map.get(uid)+"님이 들어왔습니다.";
            }else if(move.equals("Leave")){
                rst[i] = map.get(uid)+"님이 나갔습니다.";
            }
        }
        ArrayList<String> answer = new ArrayList<>();

        for(int i = 0; i < rst.length; i++){
            if(rst[i] != null)
                answer.add(rst[i]);
        }
        System.out.println(answer);

        answer.toArray(new String[0]);
    }
}
