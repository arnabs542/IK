package Tree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree {
    Node root;
    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public Node sortedArrayToBST(int[] nums) {
        root = toBST(nums, 0, nums.length-1);
        return root;
    }

    public Node toBST(int[] nums, int start, int end){
        if(start>end)
            return null;

        int middle = start +(end-start)/2;
        Node root = new Node(nums[middle]);
        root.left = toBST(nums, start, middle-1);
        root.right = toBST(nums, middle+1, end);

        return root;
    }


    void insert(int val){
        Node node = insert(root, val);
        if(root==null) root = node;
    }

    Node insert(Node root, int val) {
        if (root == null){
            return new Node(val);
        }

        if (val <= root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    String printTreeInorder(Node root){
        if(root==null)
            return "";
        return printTreeInorder(root.left)+root.val+printTreeInorder(root.right);
    }

    String postOrder(Node root){
        if(root==null)
            return "";
        return postOrder(root.left)+postOrder(root.right)+root.val;
    }

    void levelOrder(Node node){
        if(node==null)
            return ;

        Queue<Node> q = new LinkedBlockingDeque<>();
        q.add(node);
        while(q.peek()!=null) {
            Node head = q.poll();
            System.out.println(head.val);
            if (head != null) {
                if (head.left != null) q.add(head.left);
                if (head.right != null) q.add(head.right);
            }
        }

    }

    Node DeleteSingle(Node root, int val){
        if(root==null)
            return null;

        if(root.val==val) {
            return root;
        }

        if(root.val < val)
            return DeleteSingle(root.left, val);
        else
            return DeleteSingle(root.right, val);

    }

    String printTree(){
        this.levelOrder(root);
        return "";
    }
    static int result = 0;
    static int findSingleValueTrees(Node n) {

        unival(n);

        return result;
    }

    static boolean unival(Node node) {
        if(node==null)
            return true;

        if(node.left==null && node.right==null){
            result += 1;
            return true;
        }
        boolean bothKidsUnitree = unival(node.left) && unival(node.right);
        boolean isUnitree = false;
        if((node.left==null || node.val == node.left.val)
                && (node.right==null || node.val == node.right.val)
                && bothKidsUnitree){
            result+=1;
            isUnitree = true;
        }

        return isUnitree;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] nums = new int[]{1,1,1};
        Node node = tree.sortedArrayToBST(nums);
        System.out.println(tree.findSingleValueTrees(node));
    }
}
