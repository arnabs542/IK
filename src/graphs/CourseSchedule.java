package graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prereq) {
    int[] indegree = new int[numCourses];
    indegree[0] = -1;
    for(int i=0; i<prereq.length; i++){
      indegree[prereq[i][1]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for(int  i=0; i<indegree.length; i++){
      if(indegree[i]==0) queue.add(i);
    }

    while(!queue.isEmpty()){
      int course = queue.poll();
      for(int i=0; i<prereq.length; i++){
        if(prereq[i][0]==course) {
          indegree[prereq[i][1]]--;
          if(indegree[prereq[i][1]]==0)
            queue.offer(prereq[i][1]);
        }
      }
    }

    for(int i=1; i<indegree.length ; i++){
      if(indegree[i]!=0)
        return false;
    }

    return true;
  }

  @Test
  public void test(){
    Stream<Arguments> args = Stream.of(
        Arguments.of(5, new int[][]{{1,2},{2,3},{2,4},{4,3}}, true)
    );

    int[][] prereqs = new int[][]{{1,2},{2,3},{2,4},{4,3},{3,1}};
    boolean expected = false;
    int numCourses = 5;

    assertEquals(expected, canFinish(numCourses, prereqs));
  }

  private static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of(5, new int[][]{{1,2},{2,3},{2,4},{4,3}}, true)
    );
  }
}
