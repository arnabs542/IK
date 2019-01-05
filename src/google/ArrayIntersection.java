package google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> result = new HashSet<>();
    for(int i=0;i<nums1.length; i++){
      for(int j=0;j<nums2.length;j++){
        if(nums1[i]==nums2[j] && !result.contains(nums1[i]))
          result.add(nums1[i]);
      }
    }

    return result.stream().mapToInt(i->i).toArray();
  }

  // 0 msec
  public int[] intersection1(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    if(len1==0||len2==0){
      return new int[0];
    }
    if(len1>=len2){

      int max=0,min=0;
      for(int i=0;i<len2;i++){
        if(nums2[i]>max){
          max = nums2[i];
        }
      }
      boolean[] t = new boolean[max+1];
      for(int e:nums2){
        t[e] = true;
      }
      int i = 0;
      int[] result = new int[max+1];
      for(int e:nums1){
        if(e<=max){
          if(t[e]){
            t[e] = false;
            result[i++] = e;
          }
        }
      }
      return Arrays.copyOf(result,i);

    }else{
      return intersection(nums2,nums1);
    }
  }

  // 1 msec
  public int[] intersection2(int[] nums1, int[] nums2) {
    if (nums1.length == 0 || nums2.length == 0) {
      return new int[0];
    }

    int[] result = new int[nums1.length];

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int first = 0;
    int second = 0;

    int index = 0;

    while (first < nums1.length && second < nums2.length) {
      if (nums1[first] < nums2[second]) {
        first++;
      } else if (nums1[first] == nums2[second]) {
        if(index == 0 || result[index - 1] !=  nums1[first]) {
          result[index] =  nums1[first];
          index++;
        }
        first++;
        second++;
      } else {
        second++;
      }
    }

    return Arrays.copyOfRange(result, 0, index);
  }
}
