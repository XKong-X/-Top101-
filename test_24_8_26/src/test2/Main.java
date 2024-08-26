package test2;

/**
 * Created with IntelliJ IDEA.
 * Description: BM19 寻找峰值
 * Author: 行空XKong
 * Date: 2024-08-26
 * Time: 19:13
 * Version:
 */
class Solution {
    public int findPeakElement (int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {// 此时 mid 可能是波峰
                right = mid;
            } else {
                left = mid + 1;// 此时 mid + 1 可能是波峰
            }
        }
        return left;// left == right
    }
}
