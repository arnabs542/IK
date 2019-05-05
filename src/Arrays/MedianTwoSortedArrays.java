package Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MedianTwoSortedArrays {

  public double findMedianSortedArrays2(int[] arr1, int[] arr2){
    if(arr1.length>arr2.length)
      findMedianSortedArrays(arr2, arr1);

    int m = arr1.length, n = arr2.length;
    int lo = 0, hi = m;
    while(lo<=hi){
      int partitionX = (lo+hi)/2 ;
      int partitionY = (m+n+1)/2 - partitionX;
      int leftMaxX = partitionX==0 ? Integer.MIN_VALUE : arr1[partitionX-1];
      int leftMaxY = partitionY==0 ? Integer.MIN_VALUE : arr2[partitionY-1];
      int rightMinX = partitionX==m ? Integer.MAX_VALUE : arr1[partitionX];
      int rightMinY = partitionY==n ? Integer.MAX_VALUE : arr2[partitionY];

      if(leftMaxX<=rightMinY && leftMaxY<=rightMinX){
        if((m+n)%2==0)
          return ((double)Math.max(leftMaxX, leftMaxY)+Math.min(rightMinX, rightMinY))/2;
        else
          return (double)Math.max(leftMaxX, leftMaxY);
      }else{
        if(leftMaxX>rightMinY)
          hi = partitionX-1;
        else
          lo = partitionX+1;
      }
    }

    // If arrays are sorted they will have a median
    throw new IllegalArgumentException();
  }
  public double findMedianSortedArrays(int input1[], int input2[]) {
    //if input1 length is greater than switch them so that input1 is smaller than input2.
    if (input1.length > input2.length) {
      return findMedianSortedArrays(input2, input1);
    }
    int x = input1.length;
    int y = input2.length;

    int low = 0;
    int high = x;
    while (low <= high) {
      int partitionX = (low + high)/2;
      int partitionY = (x + y + 1)/2 - partitionX;

      //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
      //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
      int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
      int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

      int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
      int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        //We have partitioned array at correct place
        // Now get max of left elements and min of right elements to get the median in case of even length combined array size
        // or get max of left for odd length combined array size.
        if ((x + y) % 2 == 0) {
          return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
        } else {
          return (double)Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
        high = partitionX - 1;
      } else { //we are too far on left side for partitionX. Go on right side.
        low = partitionX + 1;
      }
    }

    //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
    throw new IllegalArgumentException();
  }

  @Test
  @MethodSource("getArgs")
  public void test(){
    int[] arr1 = new int[]{1,3,8,9,15};
    int[] arr2 = new int[]{7,11,18,19,21,25};
    int expected = 11;
    assertEquals(expected, findMedianSortedArrays(arr1, arr2));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of(new int[]{1,3,8,9,15},new int[]{7,11,18,19,21,25},11)
    );
  }
}
