package graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Alien2 {

    /*
     * Complete the function below.
     */
    static String find_order(String[] words) {
        // Make a map of all vertexes for all characters,.
        Map<Character, Vertex<Character>> map = new HashMap<>();
        for(String word : words){
            for(Character c : word.toCharArray()){
                if(!map.containsKey(c))
                    map.put(c, new Vertex(c));
            }
        }
        // Take two words at a time and compare them. Make vertex for each
        for(int k=0;k<words.length-1; k++){
            String word1 = words[k];
            String word2 = words[k+1];
            int i = 0, j=0;
            int m = word1.length();
            int n = word2.length();
            while(i<m && j<n){
                Character c1 = word1.charAt(i);
                Character c2 = word2.charAt(j);
                if(c1!=c2){
                    Vertex<Character> v1 = map.get(c1);
                    Vertex<Character> v2 = map.get(c2);
                    v1.addNodes(v2);
                }
            i++; j++;
            }
        }

        // Do a topological sort over all nodes.
        Collection<Vertex<Character>> collection = map.values();
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        for(Vertex<Character> vertex : collection){
            if(!seen.contains(vertex.value))
                dfs(vertex, seen, stack);
        }

        // Get the value of string by popping all elements of the Stack
        String result = "";
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }

    static void dfs(Vertex<Character> vertex, Set<Character> seen, Stack<Character> stack){
        if(seen.contains(vertex.value))
            return;

        seen.add(vertex.value);
        for(Vertex<Character> neighbor : vertex.getAdjacents()){
            dfs(neighbor, seen, stack);
        }
        stack.push(vertex.value);
    }

    static class Vertex<T>{
        T value;
        List<Vertex<T>> adjacents;
        Vertex(T value){
            this.value = value;
            adjacents = new ArrayList<>();
        }

        public void addNodes(Vertex<T> v){
            adjacents.add(v);
        }

        public List<Vertex<T>> getAdjacents(){
            return adjacents;
        }
    }

    @Test
    void testWords(){
        String[] words = {"baa","abcd","abca","cab","cad"};

        assertEquals("bdac", find_order(words));
    }


}
