package graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienLanguage {
    static String find_order(String[] words) {
        // Create a set of all vertexes
        Map<Character, Vertex<Character>> charSet = getCharSet(words);

        // Take two strings at a time and make connections between vertexes
        for(int i=0; i<words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int j=0, k=0;
            int m = word1.length();
            int n = word2.length();
            while(j<m && k<n){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(k);
                if(c1!=c2){
                    Vertex v1 = charSet.get(c1);
                    Vertex v2 = charSet.get(c2);
                    v1.addVertex(v2);
                    break;
                }
                k++; j++;
            }
        }

        List<Vertex<Character>> vertexList = Arrays.asList(charSet.values().toArray(new Vertex[0]));
        // Do a topological sort between vertices
        TopologicalSort sort = new TopologicalSort();
        return sort.sortTopology(vertexList);
    }

    private static Map<Character, Vertex<Character>> getCharSet(String[] words) {
        Map<Character, Vertex<Character>> map = new HashMap<>();
        for(String word : words){
            char[] chars = word.toCharArray();
            for(char c : chars){
                map.put(c, new Vertex<>(c));
            }
        }
        return map;
    }


    @Test
    void testWords(){
        String[] words = {"baa","abcd","abca","cab","cad"};

        assertEquals("bdac", find_order(words));
    }

    @Test
    void testWords2(){
        String[] words = {"tt","tttx","tttt"};

        assertEquals("xt", find_order(words));
    }

}
