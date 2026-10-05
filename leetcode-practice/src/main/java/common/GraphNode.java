package common;

import java.util.List;

public class GraphNode {

    private Integer val;
    private List<GraphNode> neighbours;

    public GraphNode(Integer val, List<GraphNode> nodes) {
        this.val = val;
        this.neighbours = nodes;
    }
}
