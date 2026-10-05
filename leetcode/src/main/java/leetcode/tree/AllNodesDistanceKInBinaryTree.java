package leetcode.tree;

import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> g = new HashMap<>();
        buildGraph(root, null, g);

        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();
        q.add(target);
        seen.add(target);
        // List<Integer> ret = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            if (k == 0) {
                return new ArrayList<>(q).stream().map(node -> node.val).collect(Collectors.toList());
            }

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                List<TreeNode> nei = g.get(cur);

                for (TreeNode n : nei) {
                    if (!seen.contains(n)) {
                        seen.add(n);
                        q.add(n);
                    }
                }
            }
            k--;
        }

        return new ArrayList<>();

    }

    public void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> g) {
        if (node == null) {
            return;
        }

        List<TreeNode> nodes = g.getOrDefault(node, new ArrayList<>());

        if (parent != null) {
            nodes.add(parent);
        }

        if (node.left != null) {
            nodes.add(node.left);
        }
        if (node.right != null) {
            nodes.add(node.right);
        }

        g.put(node, nodes);

        buildGraph(node.left, node, g);
        buildGraph(node.right, node, g);
    }
}
