package code.memory;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int number = 0;

        while (flag) {
            int temp = sc.nextInt();

            if (temp == -1)
                System.out.println("현재 숫자는 " + number + "입니다.");
            else {
                number += temp;
                System.out.println("숫자가 " + number +"로 변경되었습니다.");
            }
        }
    }
}








