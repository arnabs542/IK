package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {

    static String[][] find_all_arrangements(int size) {
        char[][] queensArr = new char[size][size];
        for(int i=0;i<queensArr.length;i++)
            Arrays.fill(queensArr[i], '-');
        List<String[]> results = new ArrayList<>();
        isNQueen(queensArr, 0, results);
        results.stream().forEach(result -> Arrays.stream(result).forEach(str -> System.out.println(str)));
        return results.toArray(new String[0][]);
    }

    public static void isNQueen(char[][] qArr, int row, List<String[]> result) {
        if (row == qArr.length) {
            String[] strArr = new String[qArr.length];
            for(int i=0;i<qArr.length;i++){
                strArr[i] = new String(Arrays.copyOf(qArr[i], qArr[i].length));
            }
            result.add(strArr);
            return;
        }

        for(int col = 0; col<qArr[row].length; col++){
            if(isValid(qArr, row, col)) {
                qArr[row][col] = 'Q';
                isNQueen(qArr, row+1, result);
                qArr[row][col] = '-';
            }
        }
    }

    private static boolean isValid(char[][] qArr, int curRow, int curCol) {
        for(int row = 0; row<curRow ; row++){
            if(qArr[row][curCol]=='Q')
                return false;
            int rowDiff = curRow - row;
            if(curCol-rowDiff >= 0 && qArr[row][curCol-rowDiff]=='Q')
                return false;
            if(curCol+rowDiff < qArr[0].length && qArr[row][curCol+rowDiff]=='Q')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        find_all_arrangements(4);
    }


}
