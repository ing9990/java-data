package stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        String[][] arr = {{"hello","world"}, {"hi","hello"}, {"bye","byebye"}, {"no no","yes yes"}};

        for(String s[] : arr)
            map.put(s[0], s[1]);

        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());

        String s = "hi";
        String rst = "";

        if(map.containsKey(s)) {
            System.out.println(s + "가 포함됨. values -> " + map.get(s));
        }

    }
}
