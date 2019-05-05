package Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Square {
  boolean square(int num){
    if(num==0 || num==1)
      return true;

    int l = 0, r=num, mid;
    while(r-l > 1){
      mid = l+(r-l)/2;
      if(mid*mid < num)
        l = mid;
      else if(mid*mid > num)
        r = mid;

      else
        return true;
    }
    return false;
  }

  @Test
  public void test(){
    int num = 101;
    boolean expected = true;
    assertEquals(expected, square(num));
  }
}
