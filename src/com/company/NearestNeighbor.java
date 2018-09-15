package com.company;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NearestNeighbor {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the find_nearest_neighbours function below.
    static int[][] find_nearest_neighbours(int px, int py, int[][] n_points, int k) {
        int[][] result = new int[k][2];
        int count = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] point : n_points){
            int x = px-point[0];
            int y = py-point[1];
            double distance = Math.sqrt(x*x+y*y);
            Point p = new Point(x, y, distance);
            if(queue.size()==k && queue.peek().distance>p.distance){
                queue.poll();
            }
            queue.add(p);
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();
            result[count++] = new int[]{p.x, p.y};
        }

        return result;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        double distance;
        Point(int x, int y, double distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            return Double.valueOf(distance).compareTo(o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int px = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int py = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int n_pointsRows = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int n_pointsColumns = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] n_points = new int[n_pointsRows][n_pointsColumns];

        for (int n_pointsRowItr = 0; n_pointsRowItr < n_pointsRows; n_pointsRowItr++) {
            String[] n_pointsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int n_pointsColumnItr = 0; n_pointsColumnItr < n_pointsColumns; n_pointsColumnItr++) {
                int n_pointsItem = Integer.parseInt(n_pointsRowItems[n_pointsColumnItr]);
                n_points[n_pointsRowItr][n_pointsColumnItr] = n_pointsItem;
            }
        }

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] res = find_nearest_neighbours(px, py, n_points, k);

        for (int resRowItr = 0; resRowItr < res.length; resRowItr++) {
            for (int resColumnItr = 0; resColumnItr < res[resRowItr].length; resColumnItr++) {
                bufferedWriter.write(String.valueOf(res[resRowItr][resColumnItr]));

                if (resColumnItr != res[resRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resRowItr != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
