package leetcode.tree;

import common.Pair;
import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;


public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> offsets = new HashMap<>();
        offsets.put(root, 0);
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            List<Integer> list = map.getOrDefault(offsets.get(node), new ArrayList<>());
            list.add(node.val);
            map.put(offsets.get(node), list);

            if (node.left != null) {
                q.add(node.left);
                offsets.put(node.left, offsets.get(node)-1);
            }
            if (node.right != null) {
                q.add(node.right);
                offsets.put(node.right, offsets.get(node)+1);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<Integer>> verticalOrder2(TreeNode root) {
        TreeMap<Integer, List<Pair<Integer, Integer>>> map = new TreeMap<>();
        build(root, 0, 0, map);

        List<List<Integer>> ret = new ArrayList<>();

        List<List<Pair<Integer, Integer>>> values = new ArrayList<>(map.values());


        for(List<Pair<Integer, Integer>> v : values) {
            Collections.sort(v, Comparator.comparingInt(Pair::getKey));
            List<Integer> temp = v.stream().map(Pair::getValue).collect(Collectors.toList());

            ret.add(temp);
        }

        return ret;
    }


    public static void build(TreeNode root, int vl, int level, TreeMap<Integer, List<Pair<Integer, Integer>>> map) {
        if (root == null) {
            return;
        }

        List<Pair<Integer, Integer>> list = map.getOrDefault(vl, new ArrayList<>());
        list.add(new Pair<>(level, root.val));

        map.put(vl, list);

        build(root.left, vl - 1, level+ 1, map);
        build(root.right, vl + 1, level + 1, map);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(20);
        n1.left = n3;
        n1.right = n5;
        n5.left = n4;
        n5.right = n2;

        System.out.println(verticalOrder2(n1));
    }
}
