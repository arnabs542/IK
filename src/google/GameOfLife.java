package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GameOfLife {
  public void gameOfLife(int[][] board) {
    // Go to each point.
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[i].length; j++){
        int cell = board[i][j];
        int liveCells = getNumLiveCells(board, i, j);
        if(cell==1 && !(liveCells<2 || liveCells>3)) {
          board[i][j] = (board[i][j] & 1) | 2;

        }
        if(cell==0 && liveCells==3)
          board[i][j] = (board[i][j] & 1) | 2;
      }
    }

    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[i].length; j++){
        board[i][j] = (board[i][j] & 2) >> 1 ;
      }
    }
  }

  // better method to get the points around.
  public int getNumLiveCells(int[][]board, int x, int y){
    int count = 0;
    for(int i = x-1; i <=x+1; i++){
      for(int j = y-1; j <= y+1; j++){
        if(i < 0 || i>= board.length || j<0 || j>=board[0].length){
          continue;
        }
        if(i ==x && j == y) continue;
        if(board[i][j] == 1) count ++;
      }
    }
    return count;
  }

  int[][] nearPos = {{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
  public int getLiveCells(int[][] board, int x, int y){
    int liveCount = 0;
    for(int i=0;i<nearPos.length;i++) {
      int xPos = x+nearPos[i][0];
      int yPos = y + nearPos[i][1];
      if(xPos>=0 && xPos<board.length && yPos>=0 && yPos<board[0].length)
        liveCount += (board[xPos][yPos] & 1);
    }

    return liveCount;
  }

  @Test
  public void test(){
    int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
    int[][] expected = {{0,0,0}, {1,0,1}, {0,1,1}, {0,1,0}};
    gameOfLife(board);
    board = expected;

    assertArrayEquals(board, expected);

  }

}
