package leetcode.arraystring;

import java.util.Arrays;

public class WiggleSortII {
	
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int[] result = new int[nums.length];
		System.arraycopy(nums, 0, result, 0, nums.length);
		Arrays.sort(result);
		
		int index = nums.length - 1;
		for (int i = 1; i < nums.length; i = i + 2) {
			nums[i] = result[index];
			index--;
		}
		
		for (int i = 0; i < result.length; i = i + 2) {
			nums[i] = result[index];
			index--;
		}
	}
}
