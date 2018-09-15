package graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 */
public class Island {
    public int numIslands(char[][] grid) {
        int total = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[i].length;j++){
                total += dfs(grid, i, j);
            }
        }

        return total;
    }

    int dfs(char[][] grid, int i, int j){
        if(i>=grid.length || i < 0 || j>=grid[i].length || j<0 || grid[i][j]=='0')
            return 0;

        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        return 1;
    }

    public int numIslands2(char[][] grid) {
        int total = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int[] row : visited)
            Arrays.fill(row, 0);
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && visited[i][j]!=1)
                    total += dfs2(grid, visited, i, j);
            }
        }

        return total;
    }

    int dfs2(char[][] grid, int[][] visited, int i, int j){
        if(i>=grid.length || i < 0 || j>=grid[i].length || j<0 || visited[i][j]==1 || grid[i][j]=='0')
            return 0;

        visited[i][j] = 1;
        dfs2(grid, visited,i+1, j);
        dfs2(grid, visited, i-1, j);
        dfs2(grid, visited, i, j+1);
        dfs2(grid, visited, i, j-1);
        return 1;
    }

    @Test
    public void testIsland(){
        char[][] grid = {
                {'0','1','1','0','1'},
                {'0','1','0','0','0'},
                {'0','0','1','0','1'},
                {'0','1','1','0','0'},
                {'0','1','1','0','1'}};

        int total = numIslands(grid);
        assertEquals(5, total);

    }

    @Test
    public void testIsland2(){
        char[][] grid = {
                {'0','1','1','0','1'},
                {'0','1','0','0','0'},
                {'0','0','1','0','1'},
                {'0','1','1','0','0'},
                {'0','1','1','0','1'}};

        assertEquals(5, numIslands2(grid));

    }
}
