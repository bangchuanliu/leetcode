package leetcode.array;

public class MedianofTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int midx = (low + high) / 2;
            int midy = (x + y + 1) / 2 - midx;

            int maxLeftx = midx == 0 ? Integer.MIN_VALUE : nums1[midx - 1];
            int minRightx = midx == x ? Integer.MAX_VALUE : nums1[midx];

            int maxLefty = midy == 0 ? Integer.MIN_VALUE : nums2[midy - 1];
            int minRighty = midy == y ? Integer.MAX_VALUE : nums2[midy];


            if (maxLeftx <= minRighty && maxLefty <= minRightx) {
                if ((x + y) % 2 == 0) {
                    int left = Math.max(maxLeftx, maxLefty);
                    int right = Math.min(minRightx, minRighty);

                    return (double) (left + right) / 2;
                } else {
                    return Math.max(maxLeftx, maxLefty);
                }
            } else if (maxLeftx > minRighty) {
                high = midx - 1;
            } else {
                low = midx + 1;
            }
        }

        return 0.0;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }


        int i = 0;
        int j = nums1.length;

        while(i <= j) {
            int mid1 = (i + j) / 2;
            int mid2 = (nums1.length + nums2.length +1)/2 - mid1;

            int leftmid1Value = mid1 == 0? Integer.MIN_VALUE: nums1[mid1-1];
            int mid1Value = mid1 == nums1.length? Integer.MAX_VALUE:  nums1[mid1];

            int leftmid2Value = mid2 == 0? Integer.MIN_VALUE: nums2[mid2-1];
            int mid2Value = mid2 == nums2.length? Integer.MAX_VALUE: nums2[mid2];

            if(leftmid1Value <= mid2Value && leftmid2Value <= mid1Value) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    int v1 = Math.max(leftmid1Value, leftmid2Value);
                    int v2 = Math.min(mid1Value, mid2Value);
                    return (v1 + v2) / 2.0;
                } else {
                    return Math.max(leftmid1Value, leftmid2Value);
                }
            } else if (leftmid2Value > mid1Value){
                i = mid1 + 1;
            } else {
                j = mid1 - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] n1 = {3, 4};
        int[] n2 = {1,2};
        System.out.println(findMedianSortedArrays2(n1, n2));
    }
}
