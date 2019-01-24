package google;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TrieNode{
  TrieNode[] next = new TrieNode[256];
  String word;
}

public class Tries {
  TrieNode root;

  public Tries() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode curr = this.root;
    for (char c : word.toCharArray()) {
      int idx = c-'a';
      if(curr.next[idx]==null)
        curr.next[idx] = new TrieNode();
      curr = curr.next[idx];
    }
    curr.word = word;
  }

  public List<String> searchprefix(String prefix) {
    List<String> result = new ArrayList<>();
    TrieNode curr = root;
    for (char c : prefix.toCharArray()) {
      if (curr.next[c - 'a'] == null)
        return result;
      curr = curr.next[c - 'a'];
    }

    dfs(curr, result);
    return result;
  }

  List<String> startsWith(String prefix){
    TrieNode curr = root;
    for(char c : prefix.toCharArray() ){
      curr = curr.next[c-'a'];
      if(curr==null)
        return null;
    }

    List<String> result = new ArrayList<>();
    Stack<TrieNode> stack = new Stack<>();
    stack.push(curr);
    while(!stack.isEmpty() && (curr=stack.pop())!=null){
      if(curr.word!=null)
        result.add(curr.word);
      for(TrieNode c : curr.next){
        if(c!=null)
          stack.push(c);
      }
    }

    return result;
  }

  void dfs(TrieNode node, List<String> list) {
    if (node == null)
      return;

    if (node.word != null)
      list.add(node.word);

    for (TrieNode n : node.next) {
      dfs(n, list);
    }
  }

  @Test
  public void test(){
    String[] words = {"atul", "aashvi", "tanvi", "deepika", "ashok"};
    Tries tries = new Tries();
    for(String word : words){
      tries.addWord(word);
    }

    List<String> result = tries.startsWith("a");
    String[] expected = {"atul","ashok","aashvi"};
    assertArrayEquals(expected, result.toArray(new String[0]));
  }
}
