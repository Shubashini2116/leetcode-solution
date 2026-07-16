class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            // Shift to 0-based indexing
            columnNumber--;
            
            // Get the current character and append it
            char c = (char) ('A' + (columnNumber % 26));
            sb.append(c);
            
            // Move to the next digit
            columnNumber /= 26;
        }
        
        // Reverse because we constructed the title from right to left
        return sb.reverse().toString();
    }
}