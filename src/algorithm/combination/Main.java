package algorithm.combination;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        String[] arr = {"1","2","3"};

        for(int i = 0 ; i < arr.length; i++)
            for(int j = 0; j < arr.length; j++)
                if(i!=j) System.out.println(arr[i] + arr[j]);


    }
}
