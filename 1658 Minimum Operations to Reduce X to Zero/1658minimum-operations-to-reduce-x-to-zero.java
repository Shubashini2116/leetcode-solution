class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // If target is negative, it's impossible to reach sum x
        if (target < 0) {
            return -1;
        }

        // If total sum equals x, we need to remove all elements
        if (target == 0) {
            return nums.length;
        }

        int maxLen = -1;
        int currentSum = 0;
        int left = 0;

        // Standard sliding window to find max subarray with sum == target
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}