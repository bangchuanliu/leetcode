package leetcode.array;

public class FirstSmallNumberThanTarget {

    public static int smallNumber(int[] nums, int x) {
        int i = 0;
        int j = nums.length - 1;
        int ret = 0;

        while( i<= j) {
            int mid = (i + j) / 2;


            if (nums[mid] < x) {
                ret = nums[mid];
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(smallNumber(nums, 8));
    }
}
