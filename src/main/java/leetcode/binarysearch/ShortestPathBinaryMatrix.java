package leetcode.binarysearch;

import common.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {

        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        q.add(new int[]{0, 0});
        int count = 0;

        Set<Pair<Integer, Integer>> seen = new HashSet<>();
        seen.add(new Pair<>(0, 0));

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};


        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == m - 1 && y == n - 1) {
                    return count;
                }

                for (int k = 0; k < 8; k++) {
                    int r = dir[k][0];
                    int c = dir[k][1];

                    int a = x + r;
                    int b = y + c;

                    if (a >= 0 && a < m && b >= 0 && b < n) {
                        Pair<Integer, Integer> next = new Pair<Integer, Integer>(a, b);
                        if (grid[a][b] == 0 && !seen.contains(next)) {
                            seen.add(next);
                            q.add(new int[]{a, b});
                        }
                    }

                }


            }
        }

        return -1;

    }
}
