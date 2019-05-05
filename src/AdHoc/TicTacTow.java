package AdHoc;

public class TicTacTow {
  public boolean validTicTacToe(String[] board) {
    int turns = 0;
    boolean xwin = false;
    boolean owin = false;
    int[] rows = new int[3];
    int[] cols = new int[3];
    int diag = 0;
    int antidiag = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i].charAt(j) == 'X') {
          turns++; rows[i]++; cols[j]++;
          if (i == j) diag++;
          if (i + j == 2) antidiag++;
        } else if (board[i].charAt(j) == 'O') {
          turns--; rows[i]--; cols[j]--;
          if (i == j) diag--;
          if (i + j == 2) antidiag--;
        }
      }
    }

    xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
        cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
        diag == 3 || antidiag == 3;
    owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
        cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
        diag == -3 || antidiag == -3;

    if (xwin && turns == 0 || owin && turns == 1) {
      return false;
    }
    return (turns == 0 || turns == 1) && (!xwin || !owin);
  }

  public boolean validTicTacToe2(String[] board) {
    int[] rowWin = new int[3];
    int[] colWin = new int[3];
    int diagWin = 0;
    int antiDiag = 0;
    int turns = 0;
    for(int i=0; i<board.length ; i++){
      for(int j=0; j<board[i].length(); j++){
        if(board[i].charAt(j)==' ')
          continue;
        if(board[i].charAt(j)=='X'){
          turns++; rowWin[i]++; colWin[j]++;
          if(i==j)   diagWin++;
          if(i+j == 2)  antiDiag++;
        }
        if(board[i].charAt(j)=='O'){
          turns--; rowWin[i]--; colWin[j]--;
          if(i==j)     diagWin--;
          if(i+j == 2) antiDiag--;
        }
      }
    }

    boolean xWin = rowWin[0]==3 || rowWin[1]==3 || rowWin[2]==3
        || colWin[0]==3 || colWin[1]==3 || colWin[2]==3
        || diagWin==3 || antiDiag==3;

    boolean oWin = rowWin[0]==-3 || rowWin[1]==-3 || rowWin[2]==-3
        || colWin[0]==-3 || colWin[1]==-3 || colWin[2]==-3
        || diagWin==-3 || antiDiag==-3;

    if(turns==0 && xWin || oWin && turns==0)
      return false;

    if(xWin && oWin)
      return false;

    return true;
  }

}
