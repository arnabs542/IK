package dp;
/*
Consider a maze mapped to a matrix with an upper left corner at coordinates (row, column) = (0, 0). Any movement must be in increasing row or column direction. You must determine the number of distinct paths through the maze. You will always start at position (0, 0), the top left, and end up at (max(row), max(column)), the bottom right.

As an example, consider the following diagram where '1' indicates an open cell and '0' indicates blocked. You can only travel through open cells, so no path can go through the cell at (0, 2). There are two distinct paths to the goal.



PS example

There are two possible paths from cell (0, 0) to cell (1, 3) in this matrix.





Function Description

Complete the function numberOfPaths in the editor below. The function must return the number of paths through the matrix, modulo (10^9 + 7).

[By doing a modulo, we get around overflow. By doing it with a prime number, we maximize chances of uniform distribution of remainders. By doing it with a large prime like 10^9 + 7, we minimize chances of repeats altogether]





numberOfPaths has the following parameter(s):

2D array of integers a.



Constraints

1 ≤ n, m ≤ 1000
Each cell in matrix a contains either a 0 or a 1.


Input Format for Custom Testing

Input from stdin will be processed as follows and passed to the function.



The first line contains an integer n, the number of rows in matrix a.

The next line contains an integer m, the number of columns in matrix a.

The next n lines each contain space separated m integer values, for row a[i] where 0 ≤ i < n.



Sample Case 0

Sample Input 0

3
4
1 1 1 1
1 1 1 1
1 1 1 1
Sample Output 0

10
Explanation 0

Sample Case 0

There are 10 possible paths from cell (0, 0) to cell (2, 3).





Sample Case 1

Sample Input 1

2
2
1 1
0 1
Sample Output 1

1
Explanation 1

Sample Case 0

There is 1 possible path from cell (0, 0) to cell (1, 1).


 */
public class NumberOfPathsInaMatrix {

}
