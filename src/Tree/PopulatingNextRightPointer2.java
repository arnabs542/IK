package Tree;

public class PopulatingNextRightPointer2 {
  public void connect(TreePointerNode root) {
    while(root != null){
      TreePointerNode tempChild = new TreePointerNode(0);
      TreePointerNode currentChild = tempChild;
      while(root!=null){
        if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
        if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
        root = root.next;
      }
      root = tempChild.next;
    }
  }

}