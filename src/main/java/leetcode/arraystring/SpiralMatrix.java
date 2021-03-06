package leetcode.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 * 
 * @author admin
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();

		if (matrix == null || matrix.length == 0) {
			return result;
		}

		int x = 0;
		int y = 0;
		int m = matrix.length;
		int n = matrix[0].length;

		while (m > 0 && n > 0) {
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			}
			if (n == 1) {
				for (int j = 0; j < m; j++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y++]);
			}

			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x++][y]);
			}

			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y--]);
			}

			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x--][y]);
			}

			x++;
			y++;
			m = m - 2;
			n = n - 2;
		}

		return result;
	}

	public static void main(String[] args) {
		SpiralMatrix instance = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> result = instance.spiralOrder(matrix);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
