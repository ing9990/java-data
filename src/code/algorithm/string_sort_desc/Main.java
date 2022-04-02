package code.algorithm.string_sort_desc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        String s = "Zbcdefg";

        ArrayList<Character> arr = new ArrayList<>();

        for(int i = 0 ; i< s.length(); i++){
            arr.add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(arr,Collections.reverseOrder());

        arr.forEach((x) ->{
            sb.append(x);
        });

    }
}
