package code.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boom = br.readLine();

        while(str.indexOf(boom) != -1)
            str = str.replace(boom,"");

        System.out.println(str.length() == 0 ? "FRULA" : str);
    }
}
