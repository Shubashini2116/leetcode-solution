public class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int matchIdx = 0;
        int starIdx = -1;
        
        int sLen = s.length();
        int pLen = p.length();

        while (sIdx < sLen) {
            // Case 1: Characters match or pattern has '?'
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } 
            // Case 2: Pattern has '*', record the star position and current match index
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                matchIdx = sIdx;
                pIdx++; // Move pattern pointer past '*'
            } 
            // Case 3: Mismatch, but we encountered a '*' earlier. Backtrack!
            else if (starIdx != -1) {
                pIdx = starIdx + 1; // Reset pattern pointer to just after the '*'
                matchIdx++;         // Advance the matched position in s (consuming a character via '*')
                sIdx = matchIdx;    // Reset string pointer to the new match position
            } 
            // Case 4: Mismatch and no '*' to backtrack to
            else {
                return false;
            }
        }

        // Check for any remaining characters in the pattern; they must all be '*'
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        // If we processed the entire pattern, it's a valid match
        return pIdx == pLen;
    }
}