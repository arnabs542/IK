package graphs;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    PriorityQueue<Vertex<Integer>> minHeap ;
    //Map<Vertex<Integer>>
}

class MinHeapMap<T>{
    private Map<T, Integer> map;
    private PriorityQueue<Node<T>> queue;
    private class Node<T>{
        T key ;
        int weight;
        Node(T key, int weight){
            this.key = key;
            this.weight = weight;
        }
    }

    public boolean containsData(T key){
        return map.containsKey(key);
    }

    public void add(T key, int weight){
        queue.add(new Node<T>(key, weight));
        map.put(key, Integer.MAX_VALUE);
    }

    public T extractMin(){
        Node<T> node = queue.poll();
        map.remove(node.key);
        return node.key;
    }
}

class MinHeapMap2<T>{
    private Map<T, Integer> map ;
    private List<Node<T>> nodeList;
    private class Node<T>{
        T key ;
        int weight;
        Node(T key, int weight){
            this.key = key;
            this.weight = weight;
        }
    }

    public boolean containsData(T key){
        return map.containsKey(key);
    }

    public void add(int weight, T key){
        nodeList.add(new Node(key, weight));
        heapifyUp(nodeList, nodeList.size()-1);
        map.put(key, Integer.MAX_VALUE);
    }

    public T extractMin(){
        Node<T> node = nodeList.remove(0);
        heapifyDown(nodeList, 0);
        //map.remove()
        return node.key;
    }

    private void heapifyDown(List<Node<T>> list, int curr){

    }

    private void heapifyUp(List<Node<T>> list, int curr){
        int parent = (curr-1)/2;
        if(parent>=0 && list.get(parent).weight> list.get(curr).weight){
            swap(list, curr, parent);
            heapifyUp(list, parent);
        }
    }

    void swap(List<Node<T>> list, int curr, int parent){
        Node<T> currNode = list.get(curr);
        Node<T> parentNode = list.get(parent);
        Node<T> temp = currNode;
        list.add(curr, parentNode);
        list.add(parent, temp);
    }

}
