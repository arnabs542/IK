package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Node{
    int value;
    Node next;
    Node previous;
    public Node(int value){
        this.value = value;
    }
}

public class LinkedList {
    Node head;
    Node tail;

    void addLast(Node node){
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        node.previous = tail;
        tail.next = node;
        tail = node;
    }

    void addFirst(Node node){
        if(head==null){
            head = node;
            tail = node;
            return;
        }

        head.previous = node;
        node.next  = head;
        head = node;

    }

    void delete(){
        if(tail == null){
            return;
        }

        tail = tail.previous;
        if(tail==null)
            head = tail;
        else
            tail.next = null;
    }

    void deleteFirst(){
        if(head == null){
            return;
        }

        head = head.next;
        head.previous = null;
    }

    void deleteNode(Node node){
        if(node.next==null){
            tail = node.previous;
            if(tail!=null)
                tail.next = null;
        }else{
            node.next.previous = node.previous;
        }
        if(node.previous==null){
            head = node.next;
            if(head!=null)
                head.previous = null;
        }else {
            node.previous.next = node.next;
        }
    }

    void replaceNode(Node node){
        deleteNode(node);
        addFirst(node);
    }

    String printList(){
        if(head==null)
            return "";

        StringBuffer buffer = new StringBuffer();
        Node current = head;
        while(current!=null) {
            buffer.append(current.value);
            buffer.append(current.next!=null ? ",":"");
            current = current.next;
        }

        return buffer.toString();
    }

}

class LinkedListTest{
    //@ParameterizedTest()
    //@MethodSource(value="testAddInputs")
    public void testAddLast(int[] input, String expected){
        LinkedList list = new LinkedList();
        for(int element : input){
            list.addLast(new Node(element));
        }

        assertEquals(expected, list.printList());
    }

/*
    static Stream<Arguments> testAddInputs(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4),"1,2,3,4"),
                Arguments.of(Arrays.asList(1),"1")
                );
    }
*/

    @Test
    public void testAddFirst(){
        int[] array = {1,2,3,4,5};
        LinkedList list = new LinkedList();
        for(int element : array){
            list.addFirst(new Node(element));
        }

        assertEquals("5,4,3,2,1", list.printList());
    }

    @Test
    public void testDeleteLast(){
        int[] array = {1,2,3,4,5};
        LinkedList list = new LinkedList();
        for(int element : array){
            list.addLast(new Node(element));
        }

        list.delete();
        assertEquals("1,2,3,4",list.printList());
    }

    @Test
    public void testDeleteFirst(){
        int[] array = {1,2,3,4,5};
        LinkedList list = new LinkedList();
        for(int element : array){
            list.addLast(new Node(element));
        }

        list.deleteFirst();
        assertEquals("2,3,4,5",list.printList());
    }

    @Test
    public void testDeleteNode(){
        int[] array = {1,2,3,4,5};
        LinkedList list = new LinkedList();
        Node node3 = null;
        for(int element : array){
            Node node = new Node(element);
            list.addLast(node);
            if(element==3)
                node3 = node;
        }

        list.deleteNode(node3);
        assertEquals("1,2,4,5",list.printList());
    }

    @Test
    public void testDeleteFirstNode(){
        int[] array = {1,2,3,4,5};
        LinkedList list = new LinkedList();
        Node node1 = null;
        for(int element : array){
            Node node = new Node(element);
            list.addLast(node);
            if(element==1)
                node1 = node;
        }

        list.deleteNode(node1);
        assertEquals("2,3,4,5",list.printList());
    }

    @Test
    public void testDeleteSingleNode(){
        int[] array = {1};
        LinkedList list = new LinkedList();
        Node node1 = null;
        for(int element : array){
            Node node = new Node(element);
            list.addLast(node);
            if(element==1)
                node1 = node;
        }

        list.deleteNode(node1);
        assertEquals("",list.printList());
    }

    @Test
    public void testDeleteListWithSingleNode(){
        int[] array = {1};
        LinkedList list = new LinkedList();
        for(int element : array){
            Node node = new Node(element);
            list.addLast(node);
        }

        list.delete();
        assertEquals("",list.printList());
    }

    @Test
    public void testReplaceFirstNode(){
        int[] array = {1,2,3,4,5};
        LinkedList list = new LinkedList();
        Node node1 = null;
        for(int element : array){
            Node node = new Node(element);
            list.addLast(node);
            if(element==4)
                node1 = node;
        }

        list.replaceNode(node1);
        assertEquals("4,1,2,3,5",list.printList());
    }

}

