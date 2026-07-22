class Solution:
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]

        def helper(arr):
            prev = curr = 0
            for n in arr:
                prev, curr = curr, max(curr, prev+n)
            return curr

        return max(helper(nums[:-1]), helper(nums[1:]))