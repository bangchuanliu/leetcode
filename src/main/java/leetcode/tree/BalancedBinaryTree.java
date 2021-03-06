package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem,
 * <p>
 * a height-balanced binary tree is defined as a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1.
 *
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 * @date Jan 28, 2015
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public int checkHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}

		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static void main(String[] args) {
		BalancedBinaryTree instance = new BalancedBinaryTree();

	}
}
