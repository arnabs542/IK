package Tree;
/*
Least Common Ancestor (LCA)





Problem Statement



You are given a binary tree of n nodes, rooted at T. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants. (For this problem, we allow a node to be an ancestor/descendant of itself.) You are also given reference of two nodes a & b, You need to find the LCA of both the nodes.



From wikipedia the definition of LCA is as follows:



The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root. Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the distance between pairs of nodes in a tree: the distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root to n2, minus twice the distance from the root to their lowest common ancestor.



Input Format:



There are three arguments in input, denoting the pointer to the root of the tree T and reference of two nodes a & b for which you need to return the LCA.

Structure of tree node is as :



class Node {

   public:

       int data;

       Node *left;

       Node *right;

};



Output Format:



Return an integer denoting the LCA for the given nodes a and b.



Constraints:



1 <= N <= 100000

1 <= Value at a <= n

1 <= Value at b <= n

Given the value stored at any node will be between 1 to n and unique.





Sample Test Case:



Sample Input:



Let us assume this is the tree, you are given the pointer to 1(Root), and two nodes 8,9











Sample Output:



5



Explanation:



Parent of 8 = 5

Parent of 9 = 5


Clearly we can see that the LCA(8,9) = 5



More examples,

LCA(2,5) = 2

LCA(2,3) = 1
 */
public class LeastCommonAncestor {

}
