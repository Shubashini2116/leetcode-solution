import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;

        // Flatten grid into 1D array and check remainder consistency
        int remainder = grid[0][0] % x;
        if (remainder < 0) remainder += x; // handle potential negative remainder

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentRemainder = grid[i][j] % x;
                if (currentRemainder < 0) currentRemainder += x;
                
                if (currentRemainder != remainder) {
                    return -1; // Impossible to make all elements equal
                }
                arr[index++] = grid[i][j];
            }
        }

        // Sort to find the median element
        Arrays.sort(arr);
        int median = arr[arr.length / 2];

        // Calculate total operations to transform all elements to the median
        int operations = 0;
        for (int val : arr) {
            operations += Math.abs(val - median) / x;
        }

        return operations;
    }
}