class Solution {
        public boolean rotateString(String s, String goal) {
                // Rotations must preserve the exact string length
                        if (s.length() != goal.length()) {
                                    return false;
                                            }
                                                    
                                                            // s + s contains every possible rotation of s
                                                                    return (s + s).contains(goal);
                                                                        }
                                                                        }
