package graphs;

import java.util.*;

public class TopologicalSort<T> {

    String sortTopology(List<Vertex<T>> vertices){
        Set<T> seen = new HashSet<>();
        Stack<Vertex<T>> stack = new Stack<>();
        for(Vertex<T> vertex : vertices){
            sort(vertex, seen, stack);
        }

        String ret = "";
        while(!stack.isEmpty()){
            T val = stack.pop().value;
            System.out.println(val);
            ret += val;
        }

        return ret;
    }

    void sort(Vertex<T> vertex, Set<T> seen, Stack<Vertex<T>> stack){
        if(seen.contains(vertex.value))
            return;

        seen.add(vertex.value);
        for(Vertex<T> neighbor : vertex.getVertices()){
            sort(neighbor, seen, stack);
        }
        stack.push(vertex);
    }

    void sort2(Vertex<Integer> vertex, Set<Integer> seen, Stack<Vertex> stack){
        if(seen.contains(vertex.value))
            return;
        seen.add(vertex.value);
        stack.push(vertex);
        for(Vertex<Integer> neighbor : vertex.getVertices()){
            if(seen.contains(neighbor.value))
                continue;
            sort2(neighbor, seen, stack);

        }
    }

    public static void main(String[] args) {
        Vertex<Integer> v1 = new Vertex(1);
        Vertex<Integer> v2 = new Vertex(2);
        Vertex<Integer> v3 = new Vertex(3);
        Vertex<Integer> v4 = new Vertex(4);
        Vertex<Integer> v5 = new Vertex(5);
        v1.addVertex(v4, v5);
        v2.addVertex(v4, v5);
        v4.addVertex(v3);
        v5.addVertex(v3);
        v3.addVertex(v1);
        List<Vertex<Integer>> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        TopologicalSort sort = new TopologicalSort();
        sort.sortTopology(list);
    }
}
