class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i >= minJump) {
                if (dp[i - minJump]) {
                    count++;
                }
            }
            if (i > maxJump) {
                if (dp[i - maxJump - 1]) {
                    count--;
                }
            }

            if (count > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}