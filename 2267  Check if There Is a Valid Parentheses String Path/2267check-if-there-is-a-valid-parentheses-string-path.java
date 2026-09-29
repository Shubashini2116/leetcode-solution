class Solution {
        private Boolean[][][] memo;
            private char[][] grid;
                private int m, n;

                    public boolean hasValidPath(char[][] grid) {
                            this.grid = grid;
                                    this.m = grid.length;
                                            this.n = grid[0].length;

                                                    // Total path length must be even to form valid parentheses
                                                            if ((m + n - 1) % 2 != 0) {
                                                                        return false;
                                                                                }

                                                                                        // Increase array size to m + n to avoid IndexOutOfBoundsException
                                                                                                memo = new Boolean[m][n][m + n];

                                                                                                        return dfs(0, 0, 0);
                                                                                                            }

                                                                                                                private boolean dfs(int r, int c, int balance) {
                                                                                                                        // Update balance for current cell
                                                                                                                                balance += (grid[r][c] == '(') ? 1 : -1;

                                                                                                                                        // If balance goes negative, the prefix is invalid
                                                                                                                                                if (balance < 0) {
                                                                                                                                                            return false;
                                                                                                                                                                    }

                                                                                                                                                                            // Reached destination
                                                                                                                                                                                    if (r == m - 1 && c == n - 1) {
                                                                                                                                                                                                return balance == 0;
                                                                                                                                                                                                        }

                                                                                                                                                                                                                // Return cached result if already computed
                                                                                                                                                                                                                        if (memo[r][c][balance] != null) {
                                                                                                                                                                                                                                    return memo[r][c][balance];
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                    boolean found = false;

                                                                                                                                                                                                                                                            // Move Down
                                                                                                                                                                                                                                                                    if (r + 1 < m) {
                                                                                                                                                                                                                                                                                found |= dfs(r + 1, c, balance);
                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                // Move Right
                                                                                                                                                                                                                                                                                                        if (!found && c + 1 < n) {
                                                                                                                                                                                                                                                                                                                    found |= dfs(r, c + 1, balance);
                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                    return memo[r][c][balance] = found;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        }
