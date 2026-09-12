class Solution {
        public int firstStableIndex(int[] nums, int k) {
                int n = nums.length;
                        int[] minRight = new int[n];
                                
                                        // Precompute suffix minimums: minRight[i] stores min(nums[i..n-1])
                                                minRight[n - 1] = nums[n - 1];
                                                        for (int i = n - 2; i >= 0; i--) {
                                                                    minRight[i] = Math.min(nums[i], minRight[i + 1]);
                                                                            }
                                                                                    
                                                                                            int maxLeft = Integer.MIN_VALUE;
                                                                                                    for (int i = 0; i < n; i++) {
                                                                                                                maxLeft = Math.max(maxLeft, nums[i]);
                                                                                                                            long instabilityScore = (long) maxLeft - minRight[i];
                                                                                                                                        
                                                                                                                                                    if (instabilityScore <= k) {
                                                                                                                                                                    return i;
                                                                                                                                                                                }
                                                                                                                                                                                        }
                                                                                                                                                                                                
                                                                                                                                                                                                        return -1;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            }
