package leetcode.tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorofaBinaryTreeIII {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        set.add(p);
        while(p.parent != null) {
            p = p.parent;
            set.add(p);
        }

        while(!set.contains(q)) {
            q = q.parent;
        }

        return q;
    }
}
