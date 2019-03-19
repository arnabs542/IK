package Tree;
/*
Balanced BST From A Sorted Array



Problem Statement:



Given a sorted array a of size N containing distinct integers, you have to build a balanced binary search tree of a.



A binary search tree is balanced if, for each node, a condition holds that the number of nodes in the left subtree and the number of nodes in the right subtree differ by at most 1.



Input/Output Format For The Function:



Input Format:



There is only one argument denoting array a.



Output Format:



You have to return the root root of the balanced BST that you created.



There can be multiple balanced BST for given input. So, you are free to return any of the valid one.



Only thing you have to consider is that it is a valid balanced BST of a.



Consider a = [1, 2] then:

1) 1 is the root of the tree and 2 is 1's right child.

2) 2 is the root of the tree and 1 is 2's left child.



Both of them will be considered as correct answer.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer N, denoting size of input array a. In next N lines, ith line should contain an integer a[i], denoting a value at index i of a.



If N = 7 and a = [8, 10, 12, 15, 16, 20, 25], then input should be:



7

8

10

12

15

16

20

25



Output Format:



There will be one line of output, containing a string “Valid Balanced BST” or “Invalid Balanced BST”.

If the root returned by solution function corresponds to a valid balanced BST, then “Valid Balanced BST”, else “Invalid Balanced BST” will be there in output.



For input N = 7 and a = [8, 10, 12, 15, 16, 20, 25], output will be:



Valid Balanced BST



Constraints:

a is sorted.
a contains distinct integers.
-2 * 10^9 <= a[i] <= 2 * 20^9
1 <= N <= 10^5


Sample Test Case:



Sample Input:



a = [8 10 12 15 16 20 25]



Sample Output:



Root of the Balanced BST where:

15 is the root node.

10 is 15's left child.

20 is 15's right child.

8 is 10's left child.

12 is 10's right child.

16 is 20's left child.

25 is 20's right child.



Explanation:



For each node, number of nodes in left subtree and number of nodes in right subtree are same (differ by 0) and also it is a BST. Hence it is a balanced BST.



Notes:

Maximum time allowed in interview: 20 Minutes.


 */
public class BalancedBSTFromSortedArray {

}
