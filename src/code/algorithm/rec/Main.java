package code.algorithm.rec;

/**
 * @author TaeWK
 */
public class Main {

    public static int recursive(int i , int ans){
        if(i == 100) return ans;
        return recursive(++i, ans+=i);
    }


    public static void main(String[] args) {
        System.out.println(recursive(0,0));
    }
}
