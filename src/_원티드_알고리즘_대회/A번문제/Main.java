package _원티드_알고리즘_대회.A번문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuffer sb = new StringBuffer();

        int number = Integer.parseInt(br.readLine());

        long fx[] = new long[1000001]; // number의 모든 약수를 더한 변수
        long dp[] = new long[1000001]; // number의 자연수 이하의 모든 fx를 더한 변수

        Arrays.fill(fx,1);

        for(int i = 2; i < fx.length; i++){
            for(int j = 1; i*j<fx.length; j++){
                fx[i*j] += i;
            }
        }

        for(int i = 1; i < dp.length; i++){
            dp[i] += dp[i-1] + fx[i];
        }

        while(number-- > 0){
            int input = Integer.parseInt(br.readLine());
            sb.append(dp[input]).append("\n");
        }

        System.out.println(sb);

    }
}
