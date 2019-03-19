package graphs;
/*
Shortest Distance From the Guard



Problem Statement:



You are given a 2D character grid of size n * m. Each element of the grid is either a GUARD, an OPEN space or a WALL. Every GUARD can move up, down, left and right in the open space. They cannot move on the wall.



Find, for every cell, the distance from the nearest guard cell. Consider -1 as this distance for WALL cells and unreachable cells.



Input/Output Format For The Function:



Input Format:



You will be given a string array rowStr of size n, where each string rowStr[i] is of length m. rowStr represents the grid. Each character in the grid will be G, O or W.



G - Guard

O - Open space

W - Wall



Output Format:



Return 2D integer array resArr, of size n * m, where resArr[i][j] representing the distance from cell in ith row and jth column to its nearest guard.

Put -1 in case of wall cells and unreachable cells.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer n, denoting no. of rows in input grid, which is also a size of array rowStr. In next n lines, ith line should contain a string rowStr[i], denoting value at index i of rowStr.



If n = 5, m = 5 and rowStr = [“OOOOG”, “OWWOO”, “OOOWO”, “GWWWO”, “OOOOG”], then input should be:



5

OOOOG

OWWOO

OOOWO

GWWWO

OOOOG



Output Format:



Let’s denote dimensions of resArr as nOutput * mOutput, where resArr is the result array returned by solution function.



There will be nOutput lines of output, where ith line contains mOutput space separated integers. So, jth integer in ith line is value resArr[i][j], denoting value at index (i, j) of resArr.



For input n = 5, m = 5 and rowStr = [“OOOOG”, “OWWOO”, “OOOWO”, “GWWWO”, “OOOOG”], output will be:



3 3 2 1 0

2 -1 -1 2 1

1 2 3 -1 2

0 -1 -1 -1 1

1 2 2 1 0



Constraints:

1 <= n, m <= 10^3


Sample Test Case:



Sample Test Case 1:



Sample Input 1:



OOOOG

OWWOO

OOOWO

GWWWO

OOOOG



Sample Output 1:



3 3 2 1 0

2 -1 -1 2 1

1 2 3 -1 2

0 -1 -1 -1 1

1 2 2 1 0



Explanation 1:



All the walls are -1. All other cells have the minimum distance to a Guard.



Sample Test Case 2:



Sample Input 2:



GWOWG



Sample Output 2:



0 -1 -1 -1 0



Explanation 2:



Open space at the middle is unreachable for the guards.


 */
public class ShortestDistanceFromGuard {

}
