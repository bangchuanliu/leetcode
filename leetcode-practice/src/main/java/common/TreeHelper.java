package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHelper {

    public static TreeNode createTree(Integer[] nums) {
        return createTree(nums, 0);
    }

    private static TreeNode createTree(Integer[] nums, int i) {
        if (i >= nums.length || nums[i] == null) return null;

        TreeNode node = new TreeNode(nums[i]);
        node.left = createTree(nums, 2 * i + 1);
        node.right = createTree(nums, 2 * i + 2);

        return node;
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    line.append(node.val).append(" ");
                    q.add(node.left);
                    q.add(node.right);
                } else {
                    line.append("null ");
                }
            }
            System.out.println(line.toString().trim());
        }
    }
}
