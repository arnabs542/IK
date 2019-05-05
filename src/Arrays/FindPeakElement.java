package Arrays;

public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int lo = 0, n = nums.length, hi = n-1;
    while(lo < hi){
      int mid = lo + (hi-lo)/2;
      if(nums[mid]<nums[mid+1])
        lo = mid+1;
      else
        hi = mid;
    }

    return lo;
  }
}
