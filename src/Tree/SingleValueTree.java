package Tree;
/*
Single Value Tree



Problem Statement:



Given a binary tree, we need to count the number of unival subtrees (all nodes that have the same value).



e.g. Given the following tree, it has 6 unival subtrees.





https://s3.amazonaws.com/istreet-assets/ZCry_llL6wcS6fdhcbjUrA/untitled-3.jpg



Input format:



There is only one argument named root denoting the root of the input tree.



Output format:



You have to return an integer denoting the number of unival subtrees.



Constraints:



0 <= number of nodes <= 100000
1 <= values stored in the nodes <= 100000
Solution should use only constant extra space.


Sample Test Case:



Sample Input 1:



  1

 / \

1  1



Sample Output 1:



3



Explanation 1:



There are three nodes, root (value: 1), left child(value: 1) and right child(value: 1).

Subtree rooted at left child has only one node. So, this is a unival subtree.
Same for subtree rooted at right child.
Subtree rooted at root has three nodes and all values are 1. So, this is also a unival subtree.
Hence answer is 3.



Sample Input 2:



  1

 / \

2  3



Sample Output 2:



2



Explanation 2:



There are three nodes, root (value: 1), left child (value: 2) and right child (value: 3).

Subtree rooted at left child has only one node. So, this is a unival subtree.
Same for subtree rooted at right child.
Subtree rooted at root has three nodes and all values are not equal So, this is not a unival subtree.


Hence, answer is 2.
 */
public class SingleValueTree {

}
