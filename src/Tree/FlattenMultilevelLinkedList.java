package Tree;

public class FlattenMultilevelLinkedList {
  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
      val = _val;
      prev = _prev;
      next = _next;
      child = _child;
    }
  };

  public Node flatten(Node head) {
    if(head==null)
      return head;

    Node curr = head;
    while(curr!=null){
      if(curr.child==null){
        curr = curr.next;
        continue;
      }

      flatten(curr.child);
      Node next = curr.next;

      curr.next = curr.child;
      curr.child = null;
      curr.next.prev = curr;
      if(next==null)
        return head;

      while(curr.next != null)
        curr = curr.next;
      curr.next = next;
      next.prev = curr;
    }

    return head;

  }
}
