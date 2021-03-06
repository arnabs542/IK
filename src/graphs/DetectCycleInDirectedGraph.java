package graphs;
/*
Detect cycle in Directed Graph





Problem Statement:



You are given Directed Graph G. You need to find out whether at least one cycle exist in the graph or not.



Input Format:



Three arguments for function, N, M and 2D Array of size M*2 where N denotes number of vertices and M denotes number of directed edges and 2D array of size M*2 represent M directed edges.

For array of size M*2, each row will represent directed edge, where value in column 1 and column 2 will be index (0-based) of starting vertex and ending vertex respectively of that directed edge.



Output Format:



Return boolean true if at least one cycle exist in graph else boolean false.



Constraints:



2 <= N <= 100000

1 <= M <= 100000

Indexing of vertices starting from 0.

No multiple edges i.e. if an edge is present which is directed from vertex u to vertex v, then no other edge will present which is directed from vertex u to vertex v.

Graph can have multiple components.



Sample Test Case:



Sample Input:



N = 5, M = 7, edges = [[0,1],[0,3],[1,3],[1,2],[2,3],[4,0],[2,4]]



Sample Output:
true

Explanation:
Graph formed from 5 vertices and given 7 directed edges have 1 cycle (0 --> 1 --> 2 --> 4 --> 0) So, Output will be true.

 */
public class DetectCycleInDirectedGraph {

}
