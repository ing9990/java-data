package code.algorithm.level1.두_개_뽑아서_더하기;

import java.util.*;

/**
 * @author TaeWK
 */

public class Main {

    static int[] numbers = {5,0,2,7};

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : numbers ) stack.push(i);

        while(! stack.isEmpty()){
            int last = stack.pop();

            for(int i = 0 ; i < stack.size(); i++)
                if( !queue.contains(stack.get(i) + last))
                    queue.offer(stack.get(i) + last);
            System.out.println(queue);
        }

        System.out.println(queue);

    }
}