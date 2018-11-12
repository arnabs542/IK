package LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipList {
  static LinkedListNode zip_given_linked_list(LinkedListNode head) {
    // Break the list into two lists
    LinkedListNode list1, list2;
    int count = 0;
    LinkedListNode curr = head;
    if(head==null)
      return null;
    while(curr!=null){
      count++;
      curr = curr.next;
    }
    list1 = head;
    curr = head;
    for(int i=0;i<count/2-1;i++){
      curr = curr.next;
    }

    list2 = curr.next;

    curr.next = null;

    // Reverse the second list
    list2 = reverse(list2);

    // Merge two lists
    LinkedListNode before = list1;
    LinkedListNode current = list2;
    LinkedListNode after = before.next;
    while(after!=null){
      before.next = current;
      before = current;
      current = after;
      after = before.next;
    }
    before.next = current;

    return head;

  }

  static LinkedListNode reverse(LinkedListNode node){
    LinkedListNode prev = null, curr, next;
    curr = node;
    next = node.next;
    while(next!=null){
      curr.next = prev;
      prev = curr;
      curr = next;
      next = curr.next;
    }
    curr.next = prev;

    return curr;
  }

  static String printList(LinkedListNode node){
    StringBuilder result = new StringBuilder();
    while(node!=null){
      result.append(node.val);
      node = node.next;
    }

    return result.toString();
  }

  @Test
  public void testZip(){
    LinkedList<String> list = new LinkedList<String>();
    list.addNode("1");
    list.addNode("2");
    list.addNode("3");
    list.addNode("4");
    list.addNode("5");
    list.addNode("10");
    LinkedListNode head = list.head;
    LinkedListNode zipped = zip_given_linked_list(head);
    assertEquals("1102534", printList(zipped));

  }
}
