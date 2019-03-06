package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Knight's Tour On A Chess Board





Problem Statement:



You are given a rows * cols chessboard and a knight that moves like in normal chess.



Currently knight is at starting position denoted by start_row th row and start_col th col, and want to reach at ending position denoted by end_row th row and end_col th col.



The goal is to calculate the minimum number of moves that the knight needs to take to get from starting position to ending position.



start_row, start_col, end_row and end_col are 0-indexed.



Input Format:



There are six arguments. First is an integer denoting rows, second is an integer denoting cols, third is an integer denoting start_row, fourth is an integer denoting start_col, fifth is an integer denoting end_row and sixth is an integer denoting end_col.



Output Format:



Return an integer.



If it is possible to reach from starting position to ending position then return minimum number of moves that the knight needs to take to get from starting position to ending position.



If it is not possible to reach from starting position to ending position then return -1.



Constraints:



1 <= rows * cols <= 10^5
0 <= start_row, end_row < rows
0 <= start_col, end_col < cols


Sample Test Case:



Sample Input:



rows = 5

cols = 5

start_row = 0

start_col = 0

end_row = 4

end_col = 1



Sample Output:



3



Explanation:



3 moves to reach from (0, 0) to (4, 1):



(0, 0) -> (1, 2) -> (3, 3) -> (4, 1).
 */
public class KnightsTour {
    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.
        Set<Vertex<Point>> seen = new HashSet<>();
        List<Vertex<Point>> vertexList = new ArrayList<>();
        getVertices(rows, cols, new Vertex(new Point(start_row, start_col)),
                new Vertex(new Point(end_row, end_col)), seen, vertexList);

        TopologicalSort<Point> sort = new TopologicalSort<>();
        sort.sortTopology(vertexList);
        return 1;
    }

    private static boolean getVertices(int rows, int cols, Vertex<Point> startPoint,
                                    Vertex<Point> endPoint, Set<Vertex<Point>> seen, List<Vertex<Point>> pointList) {
        if(!isValid(rows, cols, startPoint) || seen.contains(startPoint))
            return false;

        if(startPoint==endPoint)
            return true;

        seen.add(startPoint);
        List<Point> points = startPoint.value.getKnightsMoves();
        for(Point movePoint : points){
            Vertex<Point> vertex = new Vertex<>(movePoint);
            if(getVertices(rows, cols, vertex, endPoint, seen, pointList)) {
                startPoint.addVertex(vertex);
                pointList.add(vertex);
            }
        }
        return false;
    }

    private static boolean isValid(int rows, int cols, Vertex<Point> point) {
        int pRow = point.value.row;
        int pCol = point.value.col;
        if(pCol>=cols || pRow>=rows || pCol<0 || pRow <0)
            return false;

        return true;
    }
}

class Point{
    int row; int col;

    Point(int r, int c){
        row = r;
        col = c;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point)obj;
        return row==p.row && col == p.col ;
    }

    public List<Point> getKnightsMoves(){
        List<Point> points = new ArrayList<>();
        points.add(new Point(row+2, col+1));
        points.add(new Point(row+2, col-1));
        points.add(new Point(row-2, col+1));
        points.add(new Point(row-2, col-1));
        points.add(new Point(row+1, col+2));
        points.add(new Point(row+1, col-2));
        points.add(new Point(row-1, col+2));
        points.add(new Point(row-1, col-2));
        return points;
    }
}
