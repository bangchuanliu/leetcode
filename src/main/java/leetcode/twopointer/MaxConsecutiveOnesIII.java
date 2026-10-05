package leetcode.twopointer;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int max = 0;

        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                k--;
            }

            if (k < 0) {
                while (i < j && nums[i] != 0) {
                    i++;
                }

                i++;
                k++;
            }

            j++;
            max = Math.max(max, j - i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
