class Solution {
        public long[] resultArray(int[] nums, int k) {
                long[] ans = new long[k];
                        long[] dp = new long[k];

                                for (int num : nums) {
                                            long[] nextDp = new long[k];
                                                        int v = num % k;
                                                                    
                                                                                
                                                                                            nextDp[v]++;
                                                                                                        
                                                                                                                    
                                                                                                                                for (int r = 0; r < k; r++) {
                                                                                                                                                if (dp[r] > 0) {
                                                                                                                                                                    int nextRem = (r * v) % k;
                                                                                                                                                                                        nextDp[nextRem] += dp[r];
                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                
                                                                                                                                                                                                                                            // Accumulate into answer array
                                                                                                                                                                                                                                                        for (int r = 0; r < k; r++) {
                                                                                                                                                                                                                                                                        ans[r] += nextDp[r];
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                                                            dp = nextDp;
                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                            return ans;
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                }
