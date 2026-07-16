public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        
        // The max possible length of the product of two numbers 
        // with lengths m and n is m + n.
        int[] pos = new int[m + n];
        
        // Go from right to left for both strings
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Position indices in the result array
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Sum the current product with any existing value at p2 (the carry position)
                int sum = mul + pos[p2];
                
                // Update the positions
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        
        // Convert the array to a string result
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Skip leading zeros unless the string is empty (handles the case of "0")
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}