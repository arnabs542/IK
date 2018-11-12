package LinkedList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class LongestSubstringParenthesis {

  /*
   * Complete the function below.
   */
  static int find_max_length_of_matching_parentheses(String brackets) {
    Stack<Character> stack = new Stack<>();
    int oldLongest = 0;
    int longest = 0;
    for(int i=0;i<brackets.length();i++){
      char fchar = brackets.charAt(i);

      if(fchar=='('){
        stack.push(fchar);
        if(longest!=0) {
          oldLongest = oldLongest > longest ? oldLongest:longest;
          longest = 0;
        }
      }
      if(fchar==')'){

        if(!stack.empty()){
          longest+=2;
          stack.pop();
        }else{
          oldLongest = oldLongest > longest ? oldLongest:longest;
          longest =0;
        }

      }
    }

    oldLongest = oldLongest > longest ? oldLongest:longest;
    return oldLongest;
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int res;
    String brackets;
    try {
      brackets = in.nextLine();
    } catch (Exception e) {
      brackets = null;
    }

    res = find_max_length_of_matching_parentheses(brackets);
    bw.write(String.valueOf(res));
    bw.newLine();

    bw.close();
  }

}
