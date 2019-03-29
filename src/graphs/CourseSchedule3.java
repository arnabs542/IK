package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/course-schedule-iii/
public class CourseSchedule3 {

  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a,b)-> a[1]-b[1]);

    PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
    int time = 0;
    for(int[] course : courses){
      heap.add(course[0]);
      int deadline = course[1];
      time+=course[0];
      if(time > deadline){
        time -= heap.poll();
      }
    }
    return heap.size();
  }
}
