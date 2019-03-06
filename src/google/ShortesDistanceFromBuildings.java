package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

/*
https://leetcode.com/explore/featured/card/google/63/sorting-and-searching-4/364/
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class  ShortesDistanceFromBuildings {
  public int shortestDistance(int[][] grid) {
    // Iterate through each element and if 1 is found, do a bfs and mark the distance to each 0 cell.
    int m = grid.length;
    int n = grid[0].length;

    // Count number of total buildings
    int buildingCount = 0;
    for(int i=0; i<grid.length; i++){
      for(int j=0; j<grid[0].length; j++){
        if(grid[i][j]==1)
          buildingCount++;
      }
    }
    int[][] distance = new int[m][n];
    for(int i=0; i<m; i++){
      for(int j=0; j<n;j++){
        if(grid[i][j]==1){
          if(!bfs(grid, distance, i, j, buildingCount))
            return -1;
        }
      }
    }

    // Iterate the distance array to find the place with the shortest distance
    int min = Integer.MAX_VALUE;
    for(int i=0; i<distance.length; i++){
      for(int j=0; j<distance[0].length; j++){
        if(grid[i][j]==0 && distance[i][j]<min)
          min = distance[i][j];
      }
    }

    return min;
  }

  private boolean bfs(int[][] grid, int[][] distance, int x, int y, int buildingCount){
    Queue<int[]> queue = new LinkedList<>();
    // Store the point x, y and the level
    queue.add(new int[]{x, y, 0});
    int m = grid.length;
    int n = grid[0].length;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    // Keep track of slots already visited
    int[][] visited = new int[m][n];
    int count = 0;
    while(!queue.isEmpty()){
      int[] curr = queue.poll();
      // find all points around and if they are 0, set the corresponding distance array with distance.
      for(int i=0;i<4;i++){
        int nx = curr[0]+dx[i];
        int ny = curr[1]+dy[i];
        int level = curr[2];
        if(nx>=0 && nx<m && ny>=0 && ny<n && visited[nx][ny]==0){
          if(grid[nx][ny]==0) {
            distance[nx][ny] += level + 1;
            queue.add(new int[]{nx, ny, level + 1});
          }else
            if(grid[nx][ny]==1){
              count++;
            }
          visited[nx][ny] = 1;
        }
      }
    }

    return count == buildingCount;
  }

  @Test
  public void test(){
    int[][] input = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    int expected = 7;
    int[][] input2 = {{0,2,1},{1,0,2},{0,1,0}};
    int expected2 = -1;
    assertEquals(expected2, shortestDistance(input2));
  }
}
