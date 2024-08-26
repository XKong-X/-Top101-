package test3;

/**
 * Created with IntelliJ IDEA.
 * Description: BM21 旋转数组的最小数字
 * Author: 行空XKong
 * Date: 2024-08-26
 * Time: 21:07
 * Version:
 */
class Solution {
    public int minNumberInRotateArray (int[] nums) {
        // // 方法一（遍历）
        // int min = 10_000;
        // for (int i = 0; i < nums.length; ++i) {
        //     if (nums[i] < min) {
        //         min = nums[i];
        //     }
        // }
        // return min;

        // 方法二（归并）
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                --right;
            }
        }
        return nums[left];// left == right
    }
}
