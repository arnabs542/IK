import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Sqrt {
  public int mySqrt(int x) {
    // Prevent dividing be 0 in case of lo=0, hi=1 by keeping lo=1 in this case
    int lo = 1, hi = x;
    while(lo <= hi){
      int mid = lo + (hi-lo)/2;
      // mid*mid shouldnt be used as it will cause overflow in case of large numbers
      // instead use mid <= x/mid
      if(mid==x/mid)
        return mid;

      if(mid<x/mid)
        lo = mid+1;
      else
        hi = mid-1;
    }

    // Return hi because we want the floor of mid if sqrt is closest to mid.
    // or return lo with 1 less since this is the floor of mid.
    return lo-1;
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(int num, int expected){
    assertEquals(expected, mySqrt(num));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of(16, 4),
        Arguments.of(8, 2),
        Arguments.of(0, 0),
        Arguments.of(2147395599, 46339)
    );
  }
}
