package google;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example:
 *
 * Input:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * Output: ["eat","oath"]
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearch2 {
  public List<String> findWords(char[][] board, String[] words) {
    // Add all words to a trie
    Tries trie = new Tries();
    for(String word : words)
      trie.addWord(word);

    List<String> result = new ArrayList<>();
    for(int i=0; i<board.length; i++)
      for(int j=0; j<board[0].length; j++)
        findWords(board, trie.root, result, 0, 0);

    return result;
  }

  public void findWords(char[][] board, TrieNode trieNode, List<String> result, int row, int col){
    char c = board[row][col];
    if(c=='#' || trieNode.next[c-'a']==null)
      return ;

    trieNode = trieNode.next[c-'a'];
    if(trieNode.word!=null){
      result.add(trieNode.word);
      trieNode.word = null; // deduplicate
    }

    board[row][col] = '#';

    if(row+1<board.length)     findWords(board, trieNode, result, row+1, col);
    if(col+1<board[0].length)  findWords(board, trieNode, result, row, col+1);
    if(row-1>=0)               findWords(board, trieNode, result, row-1, col);
    if(col-1>=0)               findWords(board, trieNode, result, row, col-1);

    board[row][col] = c;
  }

  @Test
  public void test(){
    char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
    String[] words = {"oath","pea","eat","rain"};
    List<String> expected = Arrays.asList("oath", "eat");
    String[] actual = findWords(board, words).toArray(new String[0]);
    assertArrayEquals(expected.toArray(new String[0]), actual);
  }

}