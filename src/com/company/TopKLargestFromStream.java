package com.company;

import java.io.*;
import java.util.*;
public class TopKLargestFromStream {

    static int[] topK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(num -> set.add(num));
        for(int num : set){
            if(heap.size()==k && heap.peek()<num){
                heap.poll();
                heap.add(num);
            }else if(heap.size()<k){
                if(!heap.isEmpty() && heap.peek()==num)
                    continue;

                heap.add(num);
            }
        }

        return heap.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] res;
        int arr_size = 0;
        arr_size = Integer.parseInt(in.nextLine().trim());

        int[] arr = new int[arr_size];
        for(int i = 0; i < arr_size; i++) {
            int arr_item;
            arr_item = Integer.parseInt(in.nextLine().trim());
            arr[i] = arr_item;
        }

        int k;
        k = Integer.parseInt(in.nextLine().trim());

        res = topK(arr, k);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}
