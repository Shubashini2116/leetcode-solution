import java.util.Arrays;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(arr[a], arr[b]));
        
        int maxJumps = 1;
        
        for (int i : indices) {
            for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
                if (arr[j] >= arr[i]) break;
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            
            for (int j = i - 1; j >= Math.max(0, i - d); j--) {
                if (arr[j] >= arr[i]) break;
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            
            maxJumps = Math.max(maxJumps, dp[i]);
        }
        
        return maxJumps;
    }
}