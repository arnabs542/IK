package com.company.strings;

public class TrieArray {
    TrieNode root = new com.company.strings.TrieNode();

    void addWord(String word){
        char[] chars = word.toCharArray();
        com.company.strings.TrieNode curr = root;
        for(int i=0;i<chars.length;i++){
            com.company.strings.TrieNode child = curr.map.get(chars[i]);
            if(child==null){
                child = new com.company.strings.TrieNode();
                curr.map.put(chars[i], child);
            }
            curr = child;
        }

        curr.isEndOfWord = true;
    }

    public void printTrie(){
        print(root,"");
    }

    private void print(com.company.strings.TrieNode node, String result){
        if(node.isEndOfWord) {
            System.out.println(result);
            return;
        }

        for(char key : node.map.keySet()){
            print(node.map.get(key), result+key);
        }
    }

    void searchPrefix(String prefix){
        com.company.strings.TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            curr = curr.map.get(c);
            if(curr==null) {
                return ;
            }
        }

        print(curr, prefix);
    }

    public static void main(String[] args) {
        String[] words = {"atul","aashvi","deepika", "tanvi"};
        TrieArray trie = new TrieArray();
        for(String word : words){
            trie.addWord(word);
        }

        //trie.printTrie();
        trie.searchPrefix("a");
    }

}
