package google.recursion;

import google.Tries;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a set of words (without duplicates), find all word squares you can build from them.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 *
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * Note:
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 * Example 1:
 *
 * Input:
 * ["area","lead","wall","lady","ball"]
 *
 * Output:
 * [
 *   [ "wall",
 *     "area",
 *     "lead",
 *     "lady"
 *   ],
 *   [ "ball",
 *     "area",
 *     "lead",
 *     "lady"
 *   ]
 * ]
 *
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 */
public class WordSquares {
  /*
  public List<List<String>> wordSquares(String[] words) {
    List<List<String>> results = new ArrayList<>();
    for(int i=0; i<words.length; i++){
      List<String> result = new ArrayList<>();
      String tmp = words[0];
      words[0] = words[i];
      words[i] = tmp;
      result.add(words[0]);
    }

    return results;
  }


  private boolean wordSquares(String[] words, List<String> result, int index) {
    // First add up all the words to a trie.

    String prefix = "";
    for(int row=0; row<index; row++){
      char[] word = words[row].toCharArray();
      prefix += word[index];
      String[] prefixes = prefix(prefix)) {
        result.add(words[index]);
        wordSquares(words, result, index + 1);
      }
    }
    char[][] matrix = new char[words[0].length()][words[0].length()];
    for(int i=0; i<words.length; i++){
      matrix[i] = words[i].toCharArray();
      for(int column=1;column<words[i].length();column++){
        String found = ""+matrix[i][column];
        //if(found==null)

      }
    }
    // Take a word, query second character from trie to see if any results. Similarly for all characters should give different results.
    // Use a set of words to match them to second, third, forth positions etc.
    // Take a matrix (2d array of words).
    // Iterate through the array until the length of word.
    // Validation1: Check prefix for col2, row1 exist. Add a 2nd word.
    // Validation2: 2nd word - col2, row1, row2 == row2, col1, col2. They should be equal.
    // Validation1: Make a prefix and check if it exists from col3, row1, row2, row3.
    // Validation2: 3rd word - col3, row1, row2, row3 == row3, col1, col2, col3.
    // Validation1: Check prefix exits for col3, row1 + col3, row2
    // Validation2: 4th word - col4, row1, row2, row3 == row4, col1, col2, col4


    // If anytime its not matched, swap this with a different word and then check again.

    // After one whole iteration is done, if some words are left, try with those too by swapping again.
    return false;
  }
  */

  public List<List<String>> wordSquares(String[] words) {
    Tries tries = new Tries();
    for(String word : words){
      tries.addWord(word);
    }
    List<List<String>> results = new ArrayList<>();
    for(String word : words){
      List<String> result = new ArrayList<>();
      result.add(word);
      wordSquares(words, result, results, tries);
      if(result.size()==word.length())
        results.add(result);
    }

    return results;
  }

    public void wordSquares(String[] words, List<String> results, List<List<String>> list, Tries trie){
      // Create the prefix from row 0 to index-1 and column as index
      int idx = results.size();
      if(idx==words[0].length()) {
        list.add(new ArrayList<>(results));
        return;
      }

      StringBuilder prefix = new StringBuilder();
      for(String result : results)
        prefix.append(result.charAt(idx));

      List<String> matches = trie.searchprefix(prefix.toString());
      for(String match : matches){
        results.add(match);
        wordSquares(words, results, list, trie);
        results.remove(results.size()-1);
      }
    }

  @Test
  public void test(){
    String[] input2 = {"area","lead","wall","lady","ball"};
    String[] input = {"abaa","aaab","baaa","aaba"};
    int expected = 10;
    List<List<String>> actual = wordSquares(input);
    System.out.println(actual);

    assertEquals(expected, actual.size());
  }
}
