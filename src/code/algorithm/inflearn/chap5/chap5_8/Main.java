package code.algorithm.inflearn.chap5.chap5_8;

/**
 * @author Taewoo
 */


import java.util.*;

class Person {
    static int AUTO_INCREMENT = 1;

    int id;
    int number;

    public Person(int id, int number) {
        this.id = id;
        this.number = number;
    }

    public Person(int number) {
        this.id = AUTO_INCREMENT;
        this.number = number;
        AUTO_INCREMENT++;
    }
}

public class Main {
    public int solution(int[] arr, int k) {

        Queue<Person> queue = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) queue.offer(i == k ? new Person(-1, arr[i]) : new Person(arr[i]));
        int day = 1;

        while (!queue.isEmpty()) {
            Person p = queue.poll();

            int emergency = Integer.parseInt(String.valueOf(queue.stream().filter(x -> x.number > p.number).count()));

            if (emergency == 0 && p.id != -1) day++;
            else if (emergency == 0 && p.id == -1) return day;
            else queue.add(p);
        }
        return day;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(new Main().solution(arr, k));
    }
}
