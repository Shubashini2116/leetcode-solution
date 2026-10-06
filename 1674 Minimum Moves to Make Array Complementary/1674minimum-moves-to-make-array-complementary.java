class Solution {
    public int minMoves(int[] nums, int limit) {
        // diff array stores changes in required moves across target sums from 2 to 2 * limit
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int minPossible = Math.min(a, b) + 1;
            int maxPossible = Math.max(a, b) + limit;
            int sum = a + b;

            // Range [2, minPossible - 1]: Requires 2 moves
            diff[2] += 2;
            diff[minPossible] -= 2;

            // Range [minPossible, sum - 1]: Requires 1 move
            diff[minPossible] += 1;
            diff[sum] -= 1;

            // Target sum == sum: Requires 0 moves
            // (handled automatically since sum range [sum, sum] has no added penalty)

            // Range [sum + 1, maxPossible]: Requires 1 move
            diff[sum + 1] += 1;
            diff[maxPossible + 1] -= 1;

            // Range [maxPossible + 1, 2 * limit]: Requires 2 moves
            diff[maxPossible + 1] += 2;
            diff[2 * limit + 1] -= 2;
        }

        int minMoves = n;
        int currentMoves = 0;

        // Prefix sum to calculate actual moves for each target sum X
        for (int target = 2; target <= 2 * limit; target++) {
            currentMoves += diff[target];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}