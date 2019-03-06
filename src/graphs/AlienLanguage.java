package graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
/*
Find Order Of Characters From Alien Dictionary



Problem Statement:



Given a sorted dictionary of an alien language, you have to find the order of characters in that language.



(This is a popular interview problem.)



Generally, dictionary does not contain duplicate values, but for the sake of this problem, assume that dictionary might have duplicate values. (Sometimes interviewer tricks the question, to see, how you will handle it.)



Input/Output Format For The Function:



Input Format:



There is only one argument, array of strings words, which denotes sorted dictionary of an alien language.



Output Format:



Return a string ordered, denoting order of characters in the alien language.



Length of the output string will be the number of different characters present in input dictionary.



For more clarity see the sample test cases.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer n, denoting size of input array words. In next n lines, ith line should contain a string words[i], denoting a value at index i of words.



If n = 5 and words = ["baa", "abcd", "abca", "cab", "cad"], then input should be:



5

baa

abcd

abca

cab

cad



Output Format:



There will be only one line of output, containing a string ordered, denoting the result returned by solution function.



For input n = 5 and words = ["baa", "abcd", "abca", "cab", "cad"], output will be:



bdac



Constraints:

1 <= total number of characters in dictionary (not words) <= 10^5
Character in any word will be lower case alphabet letter.
Input will be such that it is possible to determine the order uniquely.


Sample Test Cases:



Sample Test Case 1:



Sample Input 1:



words = ["baa", "abcd", "abca", "cab", "cad"]



Sample Output 1:



"bdac"



Sample Test Case 2:



Sample Input 2:



words = ["caa", "aaa", "aab"]



Sample Output 2:



"cab"



Notes:

Maximum time allowed in interview: 20 Minutes.



Here input is given such that it is possible to determine order uniquely. But in interview you should clarify these things with interviewer. Like if we are given words = ["z" "bc"] then we can only conclude that 'z' will come before 'b', but nothing about the order of 'c'!
 */
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
