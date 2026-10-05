package leetcode.graph;

import common.Pair;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIsland {

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Set<Pair<Integer, Integer>>> ret = new HashSet<>();
        boolean[][] seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    Set<Pair<Integer, Integer>> set = new HashSet<>();

                    dfs(grid, i, j, set, seen, i, j);
                    ret.add(set);
                }
            }
        }

        return ret.size();
    }

    public void dfs(int[][] grid, int i, int j, Set<Pair<Integer, Integer>> set, boolean[][] seen, int lefti,
                    int leftj) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || seen[i][j]) {
            return;
        }
        seen[i][j] = true;
        Pair<Integer, Integer> p = new Pair<>(i - lefti, j - leftj);
        set.add(p);

        dfs(grid, i + 1, j, set, seen, lefti, leftj);
        dfs(grid, i - 1, j, set, seen, lefti, leftj);
        dfs(grid, i, j + 1, set, seen, lefti, leftj);
        dfs(grid, i, j - 1, set, seen, lefti, leftj);

    }
}
