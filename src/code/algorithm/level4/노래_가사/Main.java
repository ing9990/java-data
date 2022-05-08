package code.algorithm.level4.노래_가사;


import java.util.HashMap;
import java.util.Map;



class Node{


    Map<Character, Node> childNode = new HashMap<Character,Node>();


    @Override
    public String toString(){
        return this.childNode.keySet().toString();
    }
}

class Trie{
    Node root = new Node();

    void insert(String s){
        Node node = this.root;

        for(int i = 0 ; i < s.length(); i++){
            node = node.childNode.computeIfAbsent(
                    s.charAt(i), x -> new Node()
            );
        }
    }

    void search(String s){
        Node node = this.root;

        for(int i = 0; i < s.length(); i++){


        }
    }

}


class Solution {
    public int[] solution(String[] words, String[] queries) {

        Trie trie = new Trie();

        for(String s : words) trie.insert(s);

        return null;
    }
}

public class Main {
    public static void main(String[] args) {

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] result = new Solution().solution(
                words, queries
        );

        // for (int i : result) System.out.print(i + "");
    }
}
