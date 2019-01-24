package google;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergKSortedList {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public boolean equals(Object node){
      ListNode other = (ListNode)node;
      ListNode node1 =this , node2 = other;
      while(node1!=null && node2!=null){
        if(node1.val != node2.val)
          return false;
        node1 = node1.next;
        node2 = node2.next;
      }

      return node1==null && node2==null;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        if (o1.val < o2.val)
          return -1;
        else if (o1.val == o2.val)
          return 0;
        else
          return 1;
      }
    });

    for (ListNode node : lists) {
      if(node!=null)
        queue.offer(node);
    }

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (!queue.isEmpty()) {
      tail.next = queue.poll();
      tail = tail.next;
      if(tail.next!=null)
        queue.offer(tail.next);
    }

    return dummy.next;

  }

  @Test
  public void test() {
    int[][] inputs = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
    ListNode[] nodes = new ListNode[3];
    int i = 0;
    for (int[] input : inputs) {
      ListNode head = null, tail = null;

      for (int val : input) {
        ListNode node = new ListNode(val);
        if (tail == null) {
          tail = node;
          head = tail;
        } else
          tail.next = node;

        tail = node;
      }

      nodes[i++] = head;
    }

    int[] expected = {1, 1, 2, 3, 4, 4, 5, 6};
    ListNode expectedHead = null, expectedTail = null;
    for (int num : expected) {
      ListNode node = new ListNode(num);
      if (expectedHead == null) {
        expectedTail = node;
        expectedHead = expectedTail;
      }else
        expectedTail.next = node;

      expectedTail = node;
    }
    assertEquals(expectedHead, mergeKLists(nodes));
  }
}
