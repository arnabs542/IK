package google;

public class MaxConsecutiveOnes {
  // Best 1 ms
  public int findMaxConsecutiveOnesBest(int[] nums) {
    int n=nums.length;
    int i=0;
    int max=0;
    while (i<n) {
      while (i<n && nums[i]==0)
        i++;
      if (i<n) {
        int j=i;
        while (j<n && nums[j]==1)
          j++;
        if (j-i>max) max=j-i;
        i=j;
      }
    }
    return max;
  }

  public int findMaxConsecutiveOnes(int[] nums) {
    int allMax = 0;
    int tMax = 0;
    for(int i=0;i<nums.length; i++){
      if(nums[i]==1){
        tMax++;
      }
      else{
        allMax = Math.max(allMax, tMax);
        tMax=0;
      }
    }
    return Math.max(allMax, tMax);
  }
}
