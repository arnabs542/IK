package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Sqrt {

  // Notice usage of long for mid. That is to save the int boundary value from overflowing and
  // calculating wrong mid.
  public int sqrt(int x) {
    if (x == 0)
      return 0;
    int l = 1, r = x;
    while (l<r) {
      long m = l + (r - l)/2;
      if(m*m<x) l = (int)m+1;
      else      r = (int)m;
    }

    return l*l==x ? l : l-1;
  }

  public int mySqrt(int x) {
    if(x==0) return 0;
    int i=1, j=x;
    while(i<j){
      long mid=i+(j-i)/2;
      if(mid*mid<x) i=(int)mid+1;
      else j=(int)mid;
    }
    return i*i==x?i:i-1;
  }

  @Test
  public void test(){
    int input = 2147395599;
    int expected = 46339;
    assertEquals(expected, mySqrt(input));
    assertEquals(expected, sqrt(input));
  }

}
