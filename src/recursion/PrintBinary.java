package recursion;

import org.junit.jupiter.api.Test;

public class PrintBinary {

  public void printBinary(int n){
    helper(n, "");
  }

  private void helper(int n, String prefix) {
    System.out.println(String.format("helper(%d, %s)", n, prefix));
    if (n == 0) {
      System.out.println(prefix);
      return;
    }

    helper(n-1, prefix+0);
    helper(n-1, prefix+1);
  }

  @Test
  public void test(){
    printBinary(3);
  }
}