package Tree;
/*
Populate Sibling Pointers





Problem Statement:



Given a binary tree, populate nextRight pointers in each node and return the root of the tree.



Input format:



There is only one argument named root denoting the root of the input tree.



Output format:



Return the root of the tree after populating nextRight pointers



Constraints:



0 <= number of nodes <= 100000
1 <= values stored in the nodes <= 10^9


Sample Test Case:



Sample Input:



../../../../../Desktop/Screen%20Shot%202019-02-14%20at%204.5



Sample Output:



../../../../../Desktop/Screen%20Shot%202019-02-14%20at%204.5



Explanation:



﻿﻿﻿﻿There are three levels in the input tree. If we write the node values level wise then we get:

Level 1: 1

Level 2: 2, 3

Leve 3: 4, 5, 6, 7



In first level there is only one node. So, next right of node having value 1 is null.

In second level, there are 2 nodes. Left most node’s next right pointer is right most node.

In third level, there are 4 nodes. Second node is next right of first node, third node is next right to second node and fourth node is next right of third node.
 */
public class PopulateSiblingPointer {

}
