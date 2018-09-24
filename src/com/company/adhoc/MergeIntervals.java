package com.company.adhoc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeIntervals {
  /*
   * Complete the getMergedIntervals function below.
   */
  static int[][] getMergedIntervals(int[][] inputArray) {
    /*
     * Write your code here.
     */
    List<Interval> intervals = new ArrayList<>();
    for(int i=0;i<inputArray.length;i++){
      intervals.add(new Interval(inputArray[i]));
    }
    // Sort all intervals based on start
    Collections.sort(intervals);

    // Merge intervals
    // 1. If merged.end > interval.start && merged.end > interval.end -> add interval to merged
    // 2. If merged.end > interval.start && merged.end < interval.end -> merge interval to last interval
    List<Interval> result = new ArrayList<>();
    result.add(intervals.get(0));
    for(Interval interval : intervals){
      Interval last = result.get(result.size()-1);
      if(last.canMerge(interval)){
        last.mergeIntervals(interval);
      }else
        result.add(interval);
    }

    int[][] resultsArr = new int[result.size()][];
    int pos = 0;
    for(Interval interval : result){
      resultsArr[pos++] = new int[]{interval.start, interval.end};
    }

    return resultsArr;
  }

  static class Interval implements Comparable<Interval>{
    private int start;
    private int end;

    Interval(int[] input){
      start = input[0];
      end = input[1];
    }

    @Override
    public int compareTo(Interval o) {
      if(start==o.start)
        return 0;
      if(start>o.start)
        return 1;

      return -1;
    }

    public boolean canMerge(Interval second){
      if(end<second.start)
        return false;
      return true;
    }

    public void mergeIntervals(Interval second){
      if(end>=second.end)
        return;

      this.start = start;
      this.end = second.end;
    }
  }

  @Test
  public void testMerge(){
    int[][] intervals = new int[][]{{1,3},{5,7},{2,4},{6,8}};
    int[][] results = getMergedIntervals(intervals);
    int[][] expected = new int[][]{{1,4},{5,8}};

    assertEquals(results.length, expected.length);

  }

}
