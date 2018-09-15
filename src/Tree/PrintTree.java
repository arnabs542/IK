package Tree;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrintTree {
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

        static void printInorder(Node root) {
            if(root == null) return;
            printInorder(root.left);
            System.out.print(root.val+" ");
            printInorder(root.right);
        }

    /*
     * Complete the function below.
     */
    static void printAllPaths(Node root) {
        printAllPaths(root,"");
    }
    static void printAllPaths(Node root, String s) {
        if(root==null){
            return;
        }
        s = s+root.val+" ";
        if(root.left==null && root.right==null){
            System.out.println(s);
            return;
        }
        printAllPaths(root.left, s);
        printAllPaths(root.right, s);

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
        printAllPaths(n);

    }
}
