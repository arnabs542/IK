package google;

public class MaxConsecutiveOnes {
  // Best 1 ms
  public int findMaxConsecutiveOnesBest2(int[] nums) {
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

  public int findMaxConsecutiveOnes2(int[] nums) {
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

  public int findMaxConsecutiveOnesBest(int[] nums){
    int i=0, j=0, k=1;
    while(j<nums.length){
      if(nums[j++]==0)
        k-- ;
      if(k<0 && nums[i++]==0){
        k++;
      }
    }
    return j-i;
  }
}
