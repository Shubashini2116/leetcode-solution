public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 1. Traverse Right
            for (int j = colStart; j <= colEnd; j++) {
                matrix[rowStart][j] = num++;
            }
            rowStart++;
            
            // 2. Traverse Down
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;
            
            // 3. Traverse Left
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    matrix[rowEnd][j] = num++;
                }
                rowEnd--;
            }
            
            // 4. Traverse Up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = num++;
                }
                colStart++;
            }
        }
        
        return matrix;
    }
}