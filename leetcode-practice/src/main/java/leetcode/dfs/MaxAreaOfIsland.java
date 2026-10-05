package leetcode.dfs;

import static common.Util.print;
import static common.Util.println;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {

    private static int count = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    count = 0;
                    dfs(grid, i, j, seen);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    public static void dfs(int[][] g, int x, int y, boolean[][] seen) {
        if (x < 0 || y < 0 || x >= g.length || y >= g[0].length || seen[x][y] || g[x][y] == 0) {
            return;
        }

        count++;
        seen[x][y] = true;

        dfs(g, x + 1, y, seen);
        dfs(g, x - 1, y, seen);
        dfs(g, x, y + 1, seen);
        dfs(g, x, y - 1, seen);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
//        int[][] grid = {{0,1,0},{1,1,1}};
        println(MaxAreaOfIsland.maxAreaOfIsland(grid));
    }
}
