package test1;

/**
 * Created with IntelliJ IDEA.
 * Description: BM17 二分查找-I
 * Author: 行空XKong
 * Date: 2024-08-26
 * Time: 16:22
 * Version:
 */
class Solution {
    public int search (int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
