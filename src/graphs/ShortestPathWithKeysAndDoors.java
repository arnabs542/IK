package graphs;
/*
Shortest Path In 2D Grid With Keys And Doors



Problem Statement:



Given a 2D grid of size n * m, that represents a maze-like area, a start cell and a goal cell, you have to find the shortest path from start to the goal.



You can go up, down, left or right from a cell, but not diagonally.



Each cell in the grid can be either land or water or door or key to some doors.



You can only travel on land cells, key cells and door cells, and not on water cells.



Each type of key will open only one type of door. There can be multiple identical keys of the same type. There can also be multiple doors of the same type. You cannot travel through a door, unless you have picked up the key to that door before arriving there. If you have picked up a certain type of key, then it can be re-used on multiple doors of same kind.



It is allowed to revisit a cell.



Input/Output Format For The Function:



Input Format:



There is only one argument: String array rowStr.

rowStr describes the grid.



Cells in the grid can be described as:

'#' = Water.

'.' = Land.

'a' = Key of type 'a'. All lowercase letters are keys.

'A' = Door that opens with key 'a'. All uppercase letters are doors.

'@' = Starting cell.

'+' = Ending cell (goal).



Output Format:



Return a 2D integer array pathArr, containing the path from start cell to goal cell.



Suppose your path contains p cells, then output array should be of size p * 2, where (pathArr[i][0], pathArr[i][1]) describes a cell position.



Positioning of cells:

0-indexed.
Columns: Increasing from left to right.
Rows: Increasing from top to bottom.


There can be multiple shortest paths, so you are free to return any of them.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer n, denoting no. of rows in input grid, which is also a size of array rowStr. In next n lines, ith line should contain a string rowStr[i], denoting value at index i of rowStr.



If n = 3, m = 4 and rowStr = [“...B”, “.b#.”, “@#+.”], then input should be:



3

...B

.b#.

@#+.



Output Format:



Let’s denote p * 2 as dimensions of pathArr, where pathArr is the 2D array returned by solution function.



The first line of output contains a string (without quotes)   “<len> cells will be visited in shortest path.”, where “<len>”would have been replaced with value of p.

In next line, there will be a string (without quotes) “Actual path is:”.

In next p lines, ith line contains two space separated integers pathArr[i][0] and pathArr[i][1], denoting value at index (i,0) and (i,1) of pathArr respectively.



For input n = 3, m = 4 and rowStr = [“...B”, “.b#.”, “@#+.”], output will be:



9 cells will be visited in shortest path.

Actual path is:

2 0

1 0

1 1

0 1

0 2

0 3

1 3

2 3

2 2



Constraints:

1 <= n, m <= 100
There will be exactly one starting point and one goal.
It is guaranteed that there exists a path from start to goal.
'a' <= key <= 'j'
'A' <= door <= 'J'


Sample Test Case:



Sample Input:



...B

.b#.

@#+.



Sample Output:



[

   [2 0],

   [1 0],

   [1 1],

   [0 1],

   [0 2],

   [0 3],

   [1 3],

   [2 3],

   [2 2]

]



Explanation:



In order to pass through door 'B', we first need to collect key to open that door and that is 'b'.



'@' -> '.' -> 'b' -> '.' -> '.' -> 'B' -> '.' -> '.' -> '+'



Here position [2 0] is '@' in the grid above, which is the starting position.



Notes:

Maximum time allowed in interview: 20 Minutes.
 */
public class ShortestPathWithKeysAndDoors {

}
