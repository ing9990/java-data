package code.algorithm.level1._2016;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        int a = 1;
        int b = 1;
        int date = 0;

        String[] arr = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        // SUN,MON,TUE,WED,THU,FRI,SAT
        for(int i  = 1; i < a; i++){
            if(i==1 | i==3 | i==5 | i==7 | i ==8 | i==10 | i== 12)  date+=31;
            else if(i == 4 | i== 6 | i== 9 | i==11) date+=30;
            else if(i ==2) date+=29;
         }

        date += b;
        date %= 7;

        System.out.println( date == 0 ? "THU" : arr[date-1]);
    }
}
