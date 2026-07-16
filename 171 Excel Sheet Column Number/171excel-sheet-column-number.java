class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            // Shift the current result by base-26 and add the numeric value of the character (A -> 1, B -> 2, etc.)
            result = result * 26 + (c - 'A' + 1);
        }
        
        return result;
    }
}