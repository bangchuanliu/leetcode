package leetcode.tree;

import common.TreeNode;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    TreeNode pre;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode(-1);
        pre = head;
        visit(root);
        pre.right = head.right;
        head.right.left = pre;
        return head.right;
    }


    public void visit(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        visit(root.right);
    }

    //////////////////////////////
    ///   public Node treeToDoublyList(Node root) {
    ///         if (root == null) {
    ///             return null;
    ///         }
    ///         Node head = new Node(0);
    ///         Node[] pre = {head};
    ///         treeToDoublyList(root, pre);
    ///         pre[0].right = head.right;
    ///         head.right.left = pre[0];
    ///
    ///         return head.right;
    ///     }
    ///
    ///     public void treeToDoublyList(Node root, Node[] pre) {
    ///         if (root== null) {
    ///             return;
    ///         }
    ///
    ///         treeToDoublyList(root.left, pre);
    ///         root.left = pre[0];
    ///         pre[0].right = root;
    ///         pre[0] = root;
    ///         treeToDoublyList(root.right, pre);
    ///     }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n4.right = n5;
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;

        ConvertBinarySearchTreetoSortedDoublyLinkedList instance = new ConvertBinarySearchTreetoSortedDoublyLinkedList();
        TreeNode node = instance.treeToDoublyList(n4);
        for (int i = 0; i < 5; i++) {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
}
