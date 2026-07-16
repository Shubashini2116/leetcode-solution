public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 1D DP array to optimize space complexity to O(n)
        int[] dp = new int[n];
        
        // Initialize the starting point
        dp[0] = grid[0][0];
        
        // Initialize the first row (since you can only move right)
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Fill the DP table for the rest of the grid
        for (int i = 1; i < m; i++) {
            // Update the first element of the row (only reachable from above)
            dp[0] += grid[i][0];
            
            for (int j = 1; j < n; j++) {
                // The minimum sum is the value of the cell plus 
                // the minimum of coming from above (dp[j]) or left (dp[j-1])
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        
        return dp[n - 1];
    }
}