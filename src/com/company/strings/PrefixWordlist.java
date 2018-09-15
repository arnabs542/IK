package com.company.strings;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Get a minimum set of prefixes which can be used to represent all dictionary words
// Prefix should also be a dictionary valid word
public class PrefixWordlist {
    static List<String> getMinPrefixSet(List<String> dictionary){
        TrieNode root = createPrefixTree(dictionary);
        List<String> results = new LinkedList<>();
        printPrefixTree(root, "", results);
        return results;
    }

    @Test
    void testPrefixWordList(){
        List<String> dict = Arrays.asList("Pizza", "Pi","Hut","Hutch", "Atul", "At", "Tanvi");
        List<String> expected = Arrays.asList("Pi","At", "Tanvi", "Hut");
        List<String> actual = getMinPrefixSet(dict);
        assertEquals(expected, actual);
    }

    private static TrieNode createPrefixTree(List<String> words){
        TrieNode root = new TrieNode();
        for(String word: words ){
            addWord(root, word);
        }

        return root;
    }

    private static void printPrefixTree(TrieNode node, String result, List<String> results){
        if(node.isEndOfWord)
            results.add(result);

        Map<Character, TrieNode> children = node.map;
        for(char c : children.keySet()){
            printPrefixTree(children.get(c), result+c, results);
        }
    }

    private static void addWord(TrieNode node, String word){
        TrieNode curr = node;
        for(char c : word.toCharArray()){
            // If a node is found which is a complete word, delete all child nodes
            if(curr.isEndOfWord) {
                curr.map = new HashMap<>();
                return;
            }
            TrieNode childNode = curr.map.get(c);
            if(childNode==null){
                childNode = new TrieNode();
                curr.map.put(c, childNode);
            }
            curr = childNode;
        }
        curr.isEndOfWord = true;
        curr.map = new HashMap<>();
    }
}
