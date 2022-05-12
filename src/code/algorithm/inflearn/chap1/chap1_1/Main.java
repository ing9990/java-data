package code.algorithm.inflearn.chap1.chap1_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String c = sc.next();
        int answer = 0;

        s = s.toLowerCase();
        c = c.toLowerCase();

        for(char token : s.toCharArray())
            if(token == c.charAt(0))
                answer++;


        System.out.println(answer);
    }
}
