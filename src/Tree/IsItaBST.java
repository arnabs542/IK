package Tree;
/*
Is It A BST





Problem Statement:



This is a very well-known interview problem: Given a Binary Tree, check if it is a Binary Search Tree (BST). A valid BST doesn't have to be complete or balanced.



Input format:



There is only one argument named root denoting the root of the input tree.



Output format:



You have to return true if the input tree is a BST or false otherwise.



Constraints:



0 <= number of nodes <= 100000

1 <= values stored in the nodes <= 10^9

Return value must be boolean



Sample Test Case:



Sample Input 1:



  1

 / \

2  3



Sample Output 1:



  0



Explanation 1:



In the input tree, left child value(2) is greater than parent node value(1) which is a violation of BST definition.



Sample Input 2:



  2

 / \

1  3



Sample Output 2:



  1



Explanation 2:

﻿﻿﻿﻿﻿

In the input tree, left child value is less than parent node value and right child value is greater than parent node value. Also both left subtree(node having value 1) and right subtree(node having value 3) is valid BST as they are leaf nodes. So, this is a BST.
 */
public class IsItaBST {

}
