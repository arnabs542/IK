package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Heap {
    List<Integer> heap;
    int heapSize;

    public Heap(int heapSize){
        this.heap = new ArrayList<>();
        this.heapSize = heapSize;
    }

    public Heap(int[] arr){
        this.heap = new ArrayList<>();
        Arrays.stream(arr).forEach(a -> heap.add(a));
    }

    @Override
    public String toString(){
        return heap.toString();
    }

    void buildHeap(){
        for(int i=heap.size()-1; i>=0;i--){
            // If node is a leaf node, continue
            // if parent, heapify that branch
            if(i*2+1>heap.size()-1)
                continue;

            heapifyDown(heap, heapSize, i);
/*
            int leftIndex = i*2+1;
            int rightIndex = i*2+2;
            int smallestIndex = i;
            if(leftIndex<heap.size() && heap.get(leftIndex)<heap.get(smallestIndex))
                smallestIndex = leftIndex;
            if(rightIndex<heap.size() && heap.get(rightIndex)<heap.get(smallestIndex))
                smallestIndex = rightIndex;
            if(i!=smallestIndex){
                int temp = heap.get(i);
                heap.set(i, heap.get(smallestIndex));
                heap.set(smallestIndex, temp);
            }
*/
        }
    }

    Integer[] sort(){
        Integer[] copy = heap.toArray(new Integer[0]);
        List<Integer> heapCopy = Arrays.asList(copy);
        int sizeOfHeap = heapCopy.size()-1;
        for(int i=sizeOfHeap; i>=0; i--){
            swap(heapCopy, 0, i);
            sizeOfHeap = sizeOfHeap-1;
            heapifyDown(heapCopy, sizeOfHeap, 0);
        }

        return heapCopy.toArray(new Integer[0]);
    }

    static void heapifyDown(List<Integer> arr, int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<=n && arr.get(left)>arr.get(largest))
            largest = left;
        if(right<=n && arr.get(right)>arr.get(largest))
            largest = right;

        if(largest!=i){
            int temp = arr.get(largest);
            arr.set(largest, arr.get(i));
            arr.set(i, temp);
            heapifyDown(arr, n, largest);
        }
    }

    static void swap(List<Integer> heap, int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public int getMax(){
        return heap.get(0);
    }

    public int deleteMax(){
        int removed = heap.remove(0);
        heapSize = heapSize-1;
        heapifyDown(heap, heapSize, 0);
        return removed;
    }

    public void insert(int num){
        if(heap.size() == heapSize && this.getMax()<num)
            deleteMax();

        heap.add(heap.size(), num);
        heapifyUp(heap, heap.size()-1);
    }

    protected static void heapifyUp(List<Integer> arr, int curr) {
        int parent = curr / 2;
        if (parent >= 0 && arr.get(parent) < arr.get(curr)) {
            swap(arr, parent, curr);
            heapifyUp(arr, parent);
        }
    }


}

class MinHeap extends Heap{

    public MinHeap(int heapSize) {
        super(heapSize);
    }

    public MinHeap(int[] arr) {
        super(arr);
    }

    public static void heapifyDown(List<Integer> arr, int n, int i){
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(arr.get(left)<=n && arr.get(left)<arr.get(smallest))
            smallest = left;
        if(arr.get(right)<=n && arr.get(right)<arr.get(smallest))
            smallest = right;

        if(smallest!=i){
            swap(arr, smallest, i);
            heapifyDown(arr, n, smallest);
        }
    }

    public static void heapifyUp(List<Integer> arr, int i){
        int parent = i/2;
        if(parent>=0 && arr.get(parent) > arr.get(i)){
            swap(arr, parent, i);
            heapifyUp(arr, parent);
        }
    }
}

class TestHeap{
    Heap heap;

    @BeforeEach
    void setup(){
        int[] arr = {10,2,3,1,4,9,3,4,7};
        heap = new Heap(arr);
        heap.buildHeap();
    }

    @Test
    void testSort(){
        int[] expectedArr = {1,2,3,3,4,4,7,9,10};
        Integer[] actualArr = heap.sort();
        assertEquals(Arrays.toString(expectedArr), Arrays.toString(actualArr));
    }

    @Test
    void testInsertIntoEmpty(){
        Heap heap2 = new Heap(4);
        heap2.insert(10);
        assertEquals(10, heap2.getMax());
        heap2.insert(20);
        assertEquals(20, heap2.getMax());

        heap2.insert(2);
        assertEquals(20, heap2.getMax());

        heap2.insert(3);
        heap2.insert(2);

        assertEquals(20, heap2.getMax());
        assertEquals(4, heap2.heapSize);
    }

    @Test
    void testInsert(){
        assertEquals(heap.getMax(), 10);
        heap.insert(20);
        assertEquals(heap.getMax(), 20);
    }

    void testInsertMinHeap(){
        //MinHeap minHeap = new MinHeap(new int[10]{1,2,3});
    }
}