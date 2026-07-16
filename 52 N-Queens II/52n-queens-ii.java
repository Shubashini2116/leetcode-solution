public class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        // Find the bitmask containing 'n' ones at the lower end (e.g., for n=4, mask is 1111 in binary)
        int limit = (1 << n) - 1;
        backtrack(0, 0, 0, limit);
        return count;
    }

    private void backtrack(int cols, int diag1, int diag2, int limit) {
        // Base Case: If all columns are filled, we've found a valid solution
        if (cols == limit) {
            count++;
            return;
        }

        // 'occupied' has 1s where a queen cannot be placed
        int occupied = cols | diag1 | diag2;
        
        // 'availablePositions' has 1s where a queen CAN be placed (negate occupied, and mask to 'n' bits)
        int availablePositions = ~occupied & limit;

        while (availablePositions > 0) {
            // Get the lowest set bit (rightmost 1), which represents our chosen position
            int position = availablePositions & -availablePositions;
            
            // Subtract this position from the available pool
            availablePositions -= position;

            // Recurse to the next row:
            // - The column is marked (cols | position)
            // - The main diagonal is shifted right for the next row ((diag1 | position) >> 1)
            // - The anti-diagonal is shifted left for the next row ((diag2 | position) << 1)
            backtrack(
                cols | position, 
                (diag1 | position) >> 1, 
                (diag2 | position) << 1, 
                limit
            );
        }
    }
}