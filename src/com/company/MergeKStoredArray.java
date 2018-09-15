package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKStoredArray {
    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the mergeArrays function below.
     */
    static int[] mergeArrays(int[][] arrs) {
        /*
         * Write your code here.
         */
        // Calculate length of all arrays combined
        int n = arrs[0].length;
        int totalLength = arrs.length * n;
        int[] result = new int[totalLength];
        int resultCounter = 0;

        // Create a heap of k size
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i=0;i<arrs.length;i++){
            queue.add(new Node(arrs[i][0], i, 0));
        }

        while(resultCounter < totalLength){
            Node remNode = queue.poll();
            result[resultCounter++] = remNode.value;
            if(remNode.column+1<n){
                int column = remNode.column+1;
                int row = remNode.row;
                Node newNode = new Node(arrs[row][column], row, column);
                queue.add(newNode);
            }
        }
        return result;
    }

    static class Node implements Comparable<Node>{
        int value;
        int row;
        int column;
        Node(int value, int row, int column){
            this.value = value;
            this.row = row;
            this.column = column;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.valueOf(this.value).compareTo(node.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrRows = Integer.parseInt(scan.nextLine().trim());
        int arrColumns = Integer.parseInt(scan.nextLine().trim());

        int[][] arr = new int[arrRows][arrColumns];

        for (int arrRowItr = 0; arrRowItr < arrRows; arrRowItr++) {
            String[] arrRowItems = scan.nextLine().split(" ");

            for (int arrColumnItr = 0; arrColumnItr < arrColumns; arrColumnItr++) {
                int arrItem = Integer.parseInt(arrRowItems[arrColumnItr].trim());
                arr[arrRowItr][arrColumnItr] = arrItem;
            }
        }

        int[] res = mergeArrays(arr);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bw.write(String.valueOf(res[resItr]));

            if (resItr != res.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
