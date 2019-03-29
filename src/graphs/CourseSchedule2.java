package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule2 {

  public int[] findOrder(int numC, int[][] pre) {
    Stack<Integer> stack = new Stack<>();
    int[] indegree = new int[numC];
    for(int i=0; i<pre.length; i++){
      indegree[pre[i][1]]++;
    }
    Queue<Integer> que = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i=0; i<indegree.length; i++){
      if(indegree[i]==0){
        que.offer(i);
        map.put(i, new ArrayList<>());
        stack.push(i);
      }
    }

    while(!que.isEmpty()){
      int course = que.poll();
      for(int i=0; i<pre.length; i++){
        if(course==pre[i][0]){
          int prereq = pre[i][1];
          indegree[prereq]--;
          if(indegree[prereq]==0){
            que.offer(prereq);
            stack.push(prereq);
          }
        }
      }
    }

    for(int i : indegree){
      if(i!=0)
        return new int[0];
    }

    List<Integer> result = new LinkedList<>();
    while(!stack.isEmpty())
      result.add(stack.pop());

    return result.stream().mapToInt(i->i).toArray();

  }
}
