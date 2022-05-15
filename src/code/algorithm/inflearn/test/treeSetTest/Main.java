package code.algorithm.inflearn.test.treeSetTest;

/**
 * @author Taewoo
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Order by Asc
        TreeSet<Integer> treeSetAsc = new TreeSet<>();

        // Order by Desc
        TreeSet<Integer> treeSetDesc = new TreeSet<>(Collections.reverseOrder());

        // Tset ADD
        treeSetAsc.add(1);
        treeSetAsc.add(2);
        treeSetAsc.add(3);

        // Tset REMOVE
        treeSetAsc.remove(1);

        // Get Tset Size
        System.out.println("TreeSet Size:  " + treeSetAsc.size());


        // -- GET FIRST ELEMENT -- \\
        // ASC CASE  : GET MIN VALUE
        // DESC CASE : GET MAX VALUE
        System.out.println("TreeSet First: " + treeSetAsc.first());

        // -- GET LAST ELEMENT -- \\
        // ASC CASE  : GET MAX VALUE
        // DESC CASE : GET MIN VALUE
        System.out.println("TreeSet Last:  " + treeSetAsc.last());





    }
}
