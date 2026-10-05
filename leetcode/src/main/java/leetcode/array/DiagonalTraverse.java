package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = (i + j);
                List<int[]> list = map.getOrDefault(key, new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(key, list);
            }
        }


        List<List<int[]>> temp = new ArrayList<>(map.values());

        int[] ret = new int[m * n];
        int k = 0;

        for (int i = 0; i < temp.size(); i++) {
            List<int[]> part = temp.get(i);
            if (i % 2 == 0) {
                Collections.sort(part, (a, b) -> b[0] - a[0]);
            } else {
                Collections.sort(part, (a, b) -> a[0] - b[0]);
            }

            for (int[] num : part) {
                ret[k++] = mat[num[0]][num[1]];
            }

        }

        return ret;

    }
}
