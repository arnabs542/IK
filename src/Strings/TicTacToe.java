package Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TicTacToe {
  public boolean validTicTacToe(String[] board) {
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

    if(xWin && turns==0 || oWin && turns==1)
      return false;

    if(xWin && oWin)
      return false;

    if(turns!=0 && turns!=1)
      return false;

    return true;
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(String[] game, boolean expected){
    assertEquals(expected, validTicTacToe(game));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of(new String[]{"XOX","O O","XOX"}, true),
        Arguments.of(new String[]{"XOX","X  ","   "}, false)
    );
  }
}
