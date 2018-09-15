package graphs;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Graph<V> {
    List<Vertex<V>> vertices;

    public void bfs(List<Vertex<V>> adjList){
        Set<V> seen = new HashSet<>();
        for(Vertex v : adjList){
            if(!seen.contains(v.value)){
                List<V> components = new ArrayList<>();
                exploreBFS(v, seen, components);
                printTree(components);
            }
        }
    }

    private void exploreBFS(Vertex<V> v, Set<V> seen, List<V> components) {
        seen.add(v.value);
        components.add(v.value);
        Queue<Vertex<V>> queue = new LinkedBlockingDeque<>();
        queue.add(v);
        while(!queue.isEmpty()){
            Vertex<V> vertex = queue.poll();
            for(Vertex<V> child : vertex.adjacents){
                if(!seen.contains(child.value)) {
                    queue.add(child);
                    seen.add(child.value);
                    components.add(child.value);
                }
            }
        }
    }

    public void dfs(List<Vertex<V>> adjList){
        Set<V> seen = new HashSet<>();
        for(Vertex<V> curr : adjList){
            if(!seen.contains(curr.value)){
                List<V> components = new ArrayList<>();
                explore(curr, seen, components);
                printTree(components);
            }
        }
    }

    private void printTree(List<V> components) {
        System.out.println(components);
    }

    private void explore(Vertex<V> curr, Set<V> seen, List<V> components) {
        seen.add(curr.value);
        components.add(curr.value);

        for(Vertex next : curr.adjacents){
            if(!seen.contains(next.value))
                explore(next, seen, components);
        }
    }

    public static void main(String[] args) {
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);

        List<Vertex<Integer>> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        v1.addVertex(v2, v3);
        v2.addVertex(v1, v3, v4);
        v3.addVertex(v1, v2, v4);
        v4.addVertex(v2, v3);

        list.add(v3);
        list.add(v4);
        Graph graph = new Graph();
        graph.dfs(list);
        graph.bfs(list);
    }
}

class Vertex<V>{
    V value;
    List<Edge<V>> edges;
    List<Vertex<V>> adjacents;

    Vertex(V v){
        value = v;
        edges = new ArrayList<>();
    }

    void addVertex(Vertex<V>... neighbors){
        for(Vertex<V> neighbor : neighbors){
            Edge edge = new Edge(this, neighbor, 0);
            edges.add(edge);
        }
    }

    List<Vertex<V>> getVertices(){
        return adjacents;
    }
}

class Edge<V>{
    private final Vertex<V> source;
    private final Vertex<V> destination;
    private final int weight;
    Edge(Vertex<V> source, Vertex<V> destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    Vertex<V> getSource(){
        return source;
    }

    Vertex<V> getDestination(){
        return destination;
    }

    int getWeight(){
        return weight;
    }
}