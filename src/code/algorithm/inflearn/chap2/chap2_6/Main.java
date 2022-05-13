package code.algorithm.inflearn.chap2.chap2_6;
/**
 * @author Taewoo
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();

            String s = String.valueOf(new StringBuilder(String.valueOf(num)).reverse());
            arr[i] = Integer.parseInt(s);
        }

        for(int i = 0; i < arr.length; i++){

            int num = arr[i];

            if(is_prime(num)){
                System.out.print(num + " ");
            }

        }
    }

    private static boolean is_prime(int num) {

        if(num == 1) return false;

        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}

