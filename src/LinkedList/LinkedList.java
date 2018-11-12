package LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListNode<T>{
  T val;
  LinkedListNode<T> next;
  LinkedListNode(T val){
    this.val = val;
    this.next = null;
  }
}

public class LinkedList<T> {
  LinkedListNode<T> head;
  LinkedListNode<T> tail;

  public LinkedList(){
    head = tail = null;
  }

  void addNode(T val){
    LinkedListNode linkedListNode = new LinkedListNode(val);
    if(head==null){
      head = tail = linkedListNode;
    }else {
      tail.next = linkedListNode;
      tail = linkedListNode;
    }
  }

  void addNodeToStart(T val){
    LinkedListNode linkedListNode = new LinkedListNode(val);
    if(head==null){
      head = tail = linkedListNode;
    }else {
      linkedListNode.next = head;
      head = linkedListNode;
    }
  }

  LinkedListNode<T> removeNode(){
    LinkedListNode<T> result = null;
    if(head!=null){
      result = head;
      head = head.next;
    }

    return result;
  }

  void reverseList(){
    LinkedListNode<T> prev = null, curr, next;
    curr = head;
    next = head.next;
    while(next!=null){
      curr.next = prev;
      prev = curr;
      curr = next;
      next = curr.next;
    }
    curr.next = prev;
    head = curr;
  }

  String printList(){
    LinkedListNode curr = head;
    StringBuilder result = new StringBuilder();
    while(curr!=null){
      result.append(curr.val);
      curr = curr.next;
    }

    return result.toString();
  }

  @Test
  void testListAdd(){
    LinkedList<String> list = new LinkedList<String>();
    list.addNode("A");
    list.addNode("B");
    list.addNode("C");
    list.addNode("D");
    assertEquals("ABCD", list.printList());

    list.reverseList();
    assertEquals("DCBA", list.printList());
  }

  @Test
  void testRemoveNode(){
    LinkedList<String> list = new LinkedList<String>();
    list.addNode("A");
    list.addNode("B");
    list.addNode("C");
    list.addNode("D");
    list.removeNode();
    assertEquals("BCD", list.printList());
  }
}
