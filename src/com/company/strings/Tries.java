package com.company.strings;

import java.util.HashMap;
import java.util.Map;

public class Tries {
    TrieNode root = new TrieNode();

    void addWord(String word){
        char[] chars = word.toCharArray();
        TrieNode curr = root;
        for(int i=0;i<chars.length;i++){
            TrieNode child = curr.map.get(chars[i]);
            if(child==null){
                child = new TrieNode();
                curr.map.put(chars[i], child);
            }
            curr = child;
        }

        curr.isEndOfWord = true;
    }

    public void printTrie(){
        print(root,"");
    }

    private void print(TrieNode node, String result){
        if(node.isEndOfWord) {
            System.out.println(result);
        }

        for(char key : node.map.keySet()){
            print(node.map.get(key), result+key);
        }
    }

    void searchPrefix(String prefix){
        TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            curr = curr.map.get(c);
            if(curr==null) {
                return ;
            }
        }

        print(curr, prefix);
    }

    public static void main(String[] args) {
        String[] words = {"a", "atul","aashvi","deepika", "tanvi"};
        Tries trie = new Tries();
        for(String word : words){
            trie.addWord(word);
        }

        //trie.printTrie();
        trie.searchPrefix("a");
    }

}

class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    boolean isEndOfWord;
}
