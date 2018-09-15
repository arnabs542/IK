package Tree;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TreeToLinkedList {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
        }
    }

    static Node createTree(String data) {
        if (data == null || data.length() == 0) return null;
        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }

    static Node deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens())
            return null;
        String s = st.nextToken();
        if (s.equals("#"))
            return null;
        Node root = new Node(Integer.valueOf(s));
        root.left = deserialize(st);
        root.right = deserialize(st);

        return root;
    }

    /*
     * Complete the function below.
     */


    static void BSTtoLL(Node node) {
        Node list = getLL(node);
        Node curr = list;
        Node head = list;
        String result = ""+curr.val;
        while((curr=curr.right)!=null && curr!=head){
            result += " "+curr.val;
        }

        System.out.println(result);

    }

    static Node getLL(Node node) {
        if(node==null)
            return null;

        Node aList = getLL(node.left);
        Node bList = getLL(node.right);
        node.left = node;
        node.right = node;
        aList = appendNode(aList, node);
        aList = appendNode(aList, bList);

        return aList;
    }

    static Node appendNode(Node node1, Node node2){
        if(node1==null)
            return node2;
        if(node2==null)
            return node1;

        Node node1Last = node1.left;
        Node node2Last = node2.left;

        // Combine two node2
        node1Last.right = node2;
        node2.left = node1Last;

        node2Last.right = node1;
        node1.left = node2Last;

        return node1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int _size;
        _size = Integer.parseInt(in.nextLine().trim());

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        Node n = createTree(_str);
        BSTtoLL(n);

    }
}
