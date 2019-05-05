package Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RotatedArray {
  public int search(int[] A, int target) {
    int n = A.length;
    int lo=0, hi=n-1;
    while(lo<hi){
      int mid = lo + (hi-lo)/2;
      if(A[mid]>A[hi]) lo = mid+1;
      else hi = mid;
    }
    int rot = lo;
    //System.out.println("rot is "+rot);
    lo = 0; hi = n-1;
    while(lo<=hi){
      int mid = lo + (hi-lo)/2;
      int realMid = (mid+rot)%n;
      if(A[realMid]==target) return realMid;
      if(A[realMid]>target) hi = mid-1;
      else lo = mid+1;
    }
    return -1;
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(int[] A, int target, int expected){
    assertEquals(expected, search(A, target));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of(new int[]{6,7,8,1,2,3,4,5}, 7, 1)
    );
  }
}
