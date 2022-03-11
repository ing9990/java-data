package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author TaeWK
 */
public class UtilMap {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        map.put("001","kim");
        map.put("002","lee");
        map.put("003","choi");

        map.put("001","kang");

        System.out.println(map.size());

        System.out.println(map.get("001"));

        Set<String> key = map.keySet();

        System.out.println(key);

        for(String data : key)
            System.out.println(map.get(data));


    }
}
