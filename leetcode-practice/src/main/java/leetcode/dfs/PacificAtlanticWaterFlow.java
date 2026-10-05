package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ret = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pr = new boolean[m][n];
        boolean[][] ar = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pr);
            dfs(heights, i, n - 1, ar);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pr);
            dfs(heights, m - 1, j, ar);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pr[i][j] && ar[i][j]) {
                    ret.add(List.of(i, j));
                }
            }
        }

        return ret;
    }

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(int[][] heights, int i, int j, boolean[][] reachable) {
        reachable[i][j] = true;

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && heights[x][y] >= heights[i][j] && !reachable[x][y]) {
                dfs(heights, x, y, reachable);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5,}};
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        List<List<Integer>> result = pacificAtlanticWaterFlow.pacificAtlantic(matrix);

        System.out.println(Arrays.deepToString(result.toArray()));
    }
}
