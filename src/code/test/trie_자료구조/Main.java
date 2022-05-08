package code.test.trie_자료구조;

import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> childNodes = new HashMap<>();

    @Override
    public String toString(){
        return childNodes.keySet().toString();
    }
}

class Trie {

    Node rootNode = new Node();

    void insert(String s) {
        Node node = rootNode;

        for (int i = 0; i < s.length(); i++)
            node = node.childNodes.computeIfAbsent(s.charAt(i), key -> new Node());

    }

    boolean search(String s){
        Node node  = rootNode;

        for(int i = 0; i < s.length(); i++){

            node = node.childNodes.getOrDefault(s.charAt(i), null);

            System.out.print(node + " ");

            if(node == null)
                return false;
        }

        return true;
    }
}

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("banana");
        trie.insert("pineapple");
        trie.insert("grape");

        System.out.println(
                trie.search("apple") ? "apple" : "none"
        );

        System.out.println(
                trie.search("app") ? "app" : "none"
        );



    }
}
