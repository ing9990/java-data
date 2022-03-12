package coding_test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author TaeWK
 */


 class test02{
    public static void main(String[] args) {

        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] word = {"GPQM", "GPMZ", "EFU", "MMNA"};
        
        ArrayList<String> cardList = new ArrayList<>(Arrays.asList(card));
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(word));

        ArrayList<String> answer = new ArrayList<>();
        int size = 0;

        for(int i = 0; i < wordList.size(); i++){

            String thisWord = wordList.get(i);

            for(int j = 0; j < cardList.size(); j++){

               if(in(cardList.get(j),thisWord)){
                   answer.add(thisWord);
               }
            }

        }
        if(answer.size() ==0){
            String[] rst = {"-1"};
            return rst;
        }

    }

    public static boolean in(String card,String word){
        // 포함
        for(int i = 0; i< word.length(); i++){
            if(card.indexOf(word.charAt(i)) > -1){
                return true;
            }
        }
        return false;
}

