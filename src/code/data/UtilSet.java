package code.data;


import java.util.HashSet;
import java.util.Set;

/**
 * @author TaeWK
 */
public class UtilSet {
    public static void main(String[] args) {

        Set<String> set1 = new HashSet<>();

        boolean flag1 = set1.add("kang");
        boolean flag2 = set1.add("kim");
        boolean flag3 = set1.add("kang");

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);

        System.out.println(set1);

        System.out.println(set1.size());

        for (String s : set1) {
            System.out.println(s);
        }

        set1.clear();
        System.out.println(set1);

        set1.add("hello");
        set1.add("world");
        set1.remove("hello");

        System.out.println(set1);
        System.out.println(set1.contains("world"));

    }
}
