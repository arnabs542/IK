package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMissingPositive {

  public int firstMissingPositive(int[] A) {
    int n = A.length;
    for(int i = 0; i < n; ++ i)
      while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
        swap(A, i, A[i] - 1);

    for(int i = 0; i < n; ++ i)
      if(A[i] != i + 1)
        return i + 1;

    return n + 1;
  }

  private void swap(int[] A, int i, int j){
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }

  @Test
  public void test(){
    int[] input = {2,1,0};
    int expected = 3;
    assertEquals(expected, firstMissingPositive(input));
  }
}
