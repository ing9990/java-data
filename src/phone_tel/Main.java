package phone_tel;

import java.util.ArrayList;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {
        String[] phone_book = {"119","97674223","1195524421"};
        boolean answer = true;


        for(int i = 0; i < phone_book.length; i++)
            phone_book[i] = phone_book[i].replace(" ","");

        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book.length; j++){
                if(i!=j){
                    if(phone_book[i].contains(phone_book[j]) || phone_book[j].contains(phone_book[i]) )
                        answer = false;
                }
            }
        }

        System.out.println(answer);
    }
}
