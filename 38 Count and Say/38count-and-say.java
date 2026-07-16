public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        
        String res = "1";
        
        // Iteratively generate the sequence up to n
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int len = res.length();
            int count = 1;
            
            for (int j = 0; j < len; j++) {
                // If the next character is the same, increment the count
                if (j + 1 < len && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                } else {
                    // Otherwise, say the count and the character
                    sb.append(count).append(res.charAt(j));
                    count = 1; // Reset count for the next unique character
                }
            }
            res = sb.toString();
        }
        
        return res;
    }
}