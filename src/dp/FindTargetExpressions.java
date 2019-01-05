package dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/expression-add-operators/solution/
public class FindTargetExpressions {
  static List generate_all_expressions(String s, long target) {
    long valueSoFar = Long.parseLong(s);
    List<String> results = new ArrayList<String>();
    int firstEvaluation = s.charAt(0)-'0';
    generate(s, target, 0, 0, "", 0, ' ', results);
    return results;
    //return results.toArray(new String[0]);
  }

  static char[] operators = {' ','*','+'};

  static void generate(String s, long target, int index, int evaluated, String resultExp, int lastOperand, char lastOperator, List<String> results){
    if(evaluated>target)
      return ;
    if(evaluated==target){
      if(index==s.length()) {
        results.add(resultExp);
      }
      return;
    }
    int nextNum = s.charAt(index)-'0';
    for(char operator : operators){
      String newExpr = "";
      int newEval = evaluated;
      if(lastOperator=='*')
        newEval = newEval/lastOperand;
      if(lastOperator=='+')
        newEval = newEval-lastOperand;

      switch(operator){
        case ' ':
          if(lastOperand!=evaluated)
            newEval = lastOperand*10+nextNum;
          else
            newEval = lastOperand*10+nextNum;
          newExpr = resultExp+" "+nextNum;
          break;
        case '*':
          if(lastOperand!=evaluated)
            newEval = lastOperand*nextNum;
          else
            newEval = lastOperand*nextNum;

          newExpr = resultExp+"*"+nextNum;
          break;
        case '+':
          newEval = newEval + nextNum;
          newExpr = resultExp+"+"+nextNum;
      }

      // Add the new result to last evaluated based on last operator


      generate(s, target, index+1, newEval, newExpr, nextNum, operator, results);


    }
  }

  private static int eval(String resultExp) {
    Stack<Character> stack = new Stack<>();
    for(char c : resultExp.toCharArray()){

    }
    return 10;
  }

  @Test
  public void testTargetExpr(){
    List results = generate_all_expressions("6134",10);
    System.out.println(results.size()+":"+results);
  }

}
