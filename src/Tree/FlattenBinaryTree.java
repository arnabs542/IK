package Tree;



// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTree {
  public void flatten(TreeNode root) {
    if(root==null)
      return ;
    flatten(root.left);
    flatten(root.right);

    TreeNode right = root.right;

    root.right = root.left;
    root.left = null;

    TreeNode curr = root;
    while(curr.right!=null)
      curr = curr.right;
    curr.right = right;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
