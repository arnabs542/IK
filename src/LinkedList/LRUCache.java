package LinkedList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class LRUCache {

  static class Node{
    int value;
    int key;
    Node next;
    Node previous;
    public Node(int key, int value){
      this.key = key;
      this.value = value;
    }
    public String toString(){
      return this.key + ":"+this.value;
    }
  }

  static class LinkedList {
    Node head;
    Node tail;

    void addFirst(Node node){
      if(head==null){
        head = node;
        tail = node;
        return;
      }

      node.next  = head;
      head = node;
      node.next.previous = node;
    }

    public void deleteNode(){
      if(tail==null)
        return;

      Node curr = tail;
      deleteNode(curr);
    }

    public void deleteNode(Node node){
      if(node.previous==null)
        head = node.next;
      if(node.next==null)
        tail = node.previous;

      if(node.previous!=null)
        node.previous.next=node.next;
      if(node.next!=null)
        node.next.previous = node.previous;
    }


    void replaceNode(Node node){
      deleteNode(node);
      addFirst(node);
    }

    public String toString(){
      if(head==null)
        return "";

      StringBuffer buffer = new StringBuffer();
      Node current = head;
      while(current!=null) {
        buffer.append(current.key);
        buffer.append(current.next!=null ? ",":"");
        current = current.next;
      }

      return buffer.toString();
    }
  }

  /*
   * Complete the function below.
   */
  static int[] implement_LRU_cache(int capacity, int[] query_type, int[] key, int[] value) {
    // Stores the key as key of map and value as position of this provided value in linkedlist
    Map<Integer, Node> cacheMap = new HashMap<Integer, Node>();
    LinkedList keyList = new LinkedList();
    List<Integer> returnedValues = new ArrayList<Integer>();
    for(int i=0;i<query_type.length;i++){
      if(query_type[i]==0){
        // Add the linked list node to head if its accessed
        if(cacheMap.containsKey(key[i])){
          Node valueNode = cacheMap.get(key[i]);
          returnedValues.add(valueNode.value);
          // refresh the position of this element in the list
          keyList.replaceNode(valueNode);
        }else{
          returnedValues.add(-1);
        }

      }else{
        Node node = new Node(key[i], value[i]);
        if(cacheMap.containsKey(key[i])) {
          node = cacheMap.get(key[i]);
          node.value = value[i];
          keyList.replaceNode(node);
        }
        else {
          if (capacity > cacheMap.size()) {
            keyList.addFirst(node);
            cacheMap.put(key[i], node);

          }else{
            cacheMap.remove(keyList.tail.key);
            keyList.deleteNode();

            keyList.addFirst(node);
            cacheMap.put(node.key, node);
          }

        }
      }
    }
    int[] returnArray = new int[returnedValues.size()];
    for(int i=0;i<returnedValues.size();i++){
      returnArray[i] = returnedValues.get(i);
    }
    return returnArray;
  }


  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] res;
    int capacity;
    capacity = Integer.parseInt(in.nextLine().trim());

    int query_type_size = 0;
    query_type_size = Integer.parseInt(in.nextLine().trim());

    int[] query_type = new int[query_type_size];
    for(int i = 0; i < query_type_size; i++) {
      int query_type_item;
      query_type_item = Integer.parseInt(in.nextLine().trim());
      query_type[i] = query_type_item;
    }

    int key_size = 0;
    key_size = Integer.parseInt(in.nextLine().trim());

    int[] key = new int[key_size];
    for(int i = 0; i < key_size; i++) {
      int key_item;
      key_item = Integer.parseInt(in.nextLine().trim());
      key[i] = key_item;
    }

    int value_size = 0;
    value_size = Integer.parseInt(in.nextLine().trim());

    int[] value = new int[value_size];
    for(int i = 0; i < value_size; i++) {
      int value_item;
      value_item = Integer.parseInt(in.nextLine().trim());
      value[i] = value_item;
    }

    res = implement_LRU_cache(capacity, query_type, key, value);
    for(int res_i = 0; res_i < res.length; res_i++) {
      bw.write(String.valueOf(res[res_i]));
      bw.newLine();
    }

    bw.close();
  }


}
