package dp;

import java.util.Arrays;

public class MaxPath {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        int[][] grid2 = new int[][]{
                {-2,4},
                {0,6}};
        int[][] grid3 = new int[][]{
                {2,4},
                {0,-6}};
        int maxValue = maxPath(grid);
        System.out.println("Max path is "+maxValue);
        System.out.println("Max path DP is "+maxPathDP(grid));
        System.out.println("Max path grid2 "+maxPath(grid2, 0, 0));
        System.out.println("Max path grid3 "+maxPath(grid3, 0, 0));
        System.out.println("Count paths is "+countPaths(grid, 0,0));
    }

    static int maxPath(int[][] grid){
        return maxPath(grid, 0, 0);
    }

    static int maxPath(int[][] grid, int row, int col){
        if(row==grid.length-1 && col==grid[0].length-1)
            return grid[row][col];

        if(row>grid.length-1 || col>grid.length-1)
            return 0;

        return grid[row][col]+Math.max(maxPath(grid, row+1, col), maxPath(grid, row, col+1));
    }

    static int countPaths(int[][] grid, int row, int col){
        if(row==grid.length-1 && col==grid[0].length-1)
            return 1;

        if(row>grid.length-1 || col>grid[0].length-1)
            return 0;

        return countPaths(grid, row+1, col)+countPaths(grid, row, col+1);
    }

    static int maxPathDP(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] table = new int[m+1][n+1];
        for(int[] row : table)
            Arrays.fill(row,0);
        for(int r=m-1;r>=0;r--){
            for(int c=n-1;c>=0;c--){
                table[r][c] = grid[r][c] + Math.max(table[r+1][c], table[r][c+1]);
            }
        }

        return table[0][0];
    }
}
