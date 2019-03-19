package graphs;
/*
Given A Graph, Build A New One With Reversed Edges



Problem Statement:



Given a strongly connected directed graph G, containing n nodes and m edges, you have to build a new graph containing n nodes, where edges are reversed than the original graph G.



This is also called Transposing the graph.



Input/Output Format For The Function:



Input Format:



There is only one argument pointing to a random node of the graph G.



Output Format:



Return any node in the new graph.



As input is a strongly connected graph, you will be able to visit all the nodes, given any random node.



Also when we reverse all the edges of strongly connected graph it will remain strongly connected graph, hence returning any one node is sufficient.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain two space separated integers n and m, denoting no. of nodes and no. of edges in input graph G. In next m lines, each line should contain two space separated integers fromNode and toNode, denoting that there is an edge from fromNode to toNode in G.



If n = 3, m = 3 and edges = [(1 -> 2), (2 -> 3), (3 -> 1)], then input should be:



3 3

1 2

2 3

3 1



Output Format:



There will be one line of output, containing a string "Wrong Answer!" OR "Correct Answer!", depending on the evaluation of your solution’s output.



For input n = 3, m = 3 and edges = [(1 -> 2), (2 -> 3), (3 -> 1)], if your solution is correct, output will be:



Correct Answer!



Constraints:

1 <= n <= 315
Given graph does not contain multi edges (there will not be more than one edge connecting same pair of vertices in the same direction) and self loops.
Each node contains distinct values.
1 <= value stored in node <= n
You are not allowed to modify the given graph. Return completely new graph.


Sample Test Case:



Sample Input:



Any node of the graph where:

For n = 3

nodes = [1 2 3]

edges = [(1 -> 2), (2 -> 3), (3 -> 1)]



you could be given any node (1, 2 or 3) as input.



Sample Output:



Any node of the new graph where:

For n = 3

nodes = [1 2 3]

edges = [(2 -> 1), (3 -> 2), (1 -> 3)]



you could return any node as output.



Notes:

Maximum time allowed in interview: 20 Minutes.


 */
public class BuildAGraphWithReversedEdges {

}
