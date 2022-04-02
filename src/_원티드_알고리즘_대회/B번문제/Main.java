package _원티드_알고리즘_대회.B번문제;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        String s = "WAHEWHEE";
        char[] token = "WHEE".toCharArray();
        int answer  = 0;


        for(int i = 0 ; i < s.length(); i++){
            char w = token[0];
            answer  += find(s,w);
            for(int j = i; j < s.length(); j++){
                char h = token[1];
                answer  += find(s,w);
                for (int k = j; k < s.length(); k++){
                    char e1 = token[2];
                    answer  += find(s,w);
                    for(int l = k ; l < s.length(); l++){
                        char e2 = token[3];
                        answer  += find(s,w);
                    }
                }
            }
        }



    }

    public static int find(String s, char iden){
        int answer = 0 ;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == iden)  answer  ++;
        }
        return answer;
    }
}
