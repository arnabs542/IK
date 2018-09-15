package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
