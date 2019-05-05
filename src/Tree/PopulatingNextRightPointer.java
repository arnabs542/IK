package Tree;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointer {
  public TreePointerNode connect(TreePointerNode root) {
    return dfs(root, null);
  }

  public TreePointerNode dfs(TreePointerNode node, TreePointerNode next){
    if(node==null)
      return null;
    node.next = next;
    dfs(node.left, node.right);
    dfs(node.right, node.next!=null ? node.next.left : null);
    return node;
  }
}

class TreePointerNode {
  public int val;
  public TreePointerNode left;
  public TreePointerNode right;
  public TreePointerNode next;

  public TreePointerNode() {
    this(0);
  }

  public TreePointerNode(int _val) {
    val = _val;
  }
}


