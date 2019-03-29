package Sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ListNode{
  int val;
  ListNode next;
  int[] list;

  ListNode(int val){
    this.val = val;
  }

  ListNode(int[] list){
    this.list = list;

  }

  @Override
  public boolean equals(Object obj2){
    return Arrays.equals(list, ((ListNode) obj2).list);
  }

  static ListNode of(int[] vals){
    ListNode head=null, tail=null;
    for(int val : vals){
      ListNode node = new ListNode(val);
      if(head == null){
        head = node;
      }

      if(tail == null)
        tail = node;
      else {
        tail.next = node;
        tail = tail.next;
      }
    }

    return head;
  }
}

public class MergeTwoSortedList {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    if(l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l2.next, l1);
      return l2;
    }
  }

  public ListNode mergeTwoListsI(ListNode l1, ListNode l2) {
    // maintain an unchanging reference to node ahead of the return node.
    ListNode prehead = new ListNode(-1);

    ListNode prev = prehead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }

    // exactly one of l1 and l2 can be non-null at this point, so connect
    // the non-null list to the end of the merged list.
    prev.next = l1 == null ? l2 : l1;

    return prehead.next;
  }

  // Tests not coded properly. TBD
  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(ListNode l1, ListNode l2, ListNode expected){
    assertEquals(expected, mergeTwoLists(l1, l2));
  }

  private static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of(ListNode.of(new int[]{1,3,6}), ListNode.of(new int[]{2,4,5}), ListNode.of(new int[]{1,2,3,4,2,6})
    ));
  }
}
