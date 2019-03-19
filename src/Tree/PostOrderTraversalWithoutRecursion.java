package Tree;
/*
Post-order Traversal of a Tree Without Recursion



Problem Statement:



Write a function to traverse a binary tree Post-order, without using recursion. As you traverse, please print contents of the nodes.



e.g. for a tree that's

../../../../../Desktop/Screen%20Shot%202019-01-20%20at%2010.4



Print:

4 5 2 6 7 3 1



While printing make sure that there is no space at the end. (There is no space after 1).



Input format:



There is only one argument named root denoting the root of the input tree.



Output format:



Print the node values in post-order traversal of the tree



Constraints:



0 <= number of nodes <= 100000
1 <= values stored in the nodes <= 10^9


Sample Test Case:



Sample Input:



../../../../../Desktop/Screen%20Shot%202019-01-20%20at%2010.5



Sample Output:



4 5 2 3 1



Explanation:



There are 5 nodes in the tree. As post-order traversal sequence is left_node -> right_node -> parent_node, so from root (1) it goes to left node (2). Left node has two children. So, it goes to left (4) again which is a leaf node. Print the content of this node. Go to parent’s right (5) node which is also a leaf node. Print the content and go back to parent (2) node, print the content and go back to its parent (1). Repeat this process for right side and print the root node (1) at last.


 */
public class PostOrderTraversalWithoutRecursion {

}
