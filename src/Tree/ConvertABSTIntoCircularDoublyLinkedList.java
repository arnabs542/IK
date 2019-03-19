package Tree;

/*
Convert a BST into a Circular Doubly Linked List



Problem Statement:



Write a recursive function BSTtoLL(TreeNode root) that takes a BST and rearranges the internal pointers to make a circular doubly linked list out of the tree nodes. The "previous" pointers should be stored in the "left_ptr" field and the "next" pointers should be stored in the "right_ptr" field. The list should be arranged so that the nodes are in increasing order. Print (space separated) the resulting linked list starting from its head node. (see	test-case output to understand the formatting). The operation can be done in O(n) time



e.g. for a tree that's

﻿﻿﻿

../../../../../Desktop/Screen%20Shot%202019-02-11%20at%2010.5



Print:

1 2 3 4 5 6 7



Input format:



There is only one argument named root denoting the root of the input tree.



Output format:



Print the node values in post-order traversal of the tree



Constraints:



0 <= number of nodes <= 100000
1 <= values stored in the nodes <= 10^9
Input tree will be a BST


Sample Test Case:



Sample Input:



../../../../../Desktop/Screen%20Shot%202019-02-11%20at%2010.4



Sample Output:



1 2 3 4 5



Explanation:



As the output must be must be in increasing order, so left most node will be the head of the resultant circular doubly linked list. The circular list will look like the following:



../../../../../Desktop/Screen%20Shot%202019-02-11%20at%2011.0


 */
public class ConvertABSTIntoCircularDoublyLinkedList {

}
