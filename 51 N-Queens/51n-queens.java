import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> result = new ArrayList<>();
    private boolean[] cols;
    private boolean[] diag1; // Main diagonals: row - col
    private boolean[] diag2; // Anti-diagonals: row + col

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        
        // Initialize the board with empty spots '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(board, 0, n);
        return result;
    }

    private void backtrack(char[][] board, int row, int n) {
        // Base Case: If all queens are successfully placed
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n; // Offset to prevent negative index
            int d2 = row + col;

            // Check if placing a queen here is valid
            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                // Place the queen
                board[row][col] = 'Q';
                cols[col] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                // Move to the next row
                backtrack(board, row + 1, n);

                // Backtrack: Remove the queen and reset tracking
                board[row][col] = '.';
                cols[col] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }

    // Helper method to convert the char array board into the required string list format
    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}