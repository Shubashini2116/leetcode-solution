class Solution {
    class TrieNode {
        int bestIndex = -1;
        int minLen = Integer.MAX_VALUE;
        TrieNode[] children = new TrieNode[26];
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        
        for (int i = 0; i < wordsContainer.length; i++) {
            String s = wordsContainer[i];
            int len = s.length();
            TrieNode curr = root;
            
            if (curr.bestIndex == -1 || len < curr.minLen || (len == curr.minLen && i < curr.bestIndex)) {
                curr.bestIndex = i;
                curr.minLen = len;
            }
            
            for (int j = len - 1; j >= 0; j--) {
                int idx = s.charAt(j) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
                
                if (curr.bestIndex == -1 || len < curr.minLen || (len == curr.minLen && i < curr.bestIndex)) {
                    curr.bestIndex = i;
                    curr.minLen = len;
                }
            }
        }
        
        int m = wordsQuery.length;
        int[] ans = new int[m];
        
        for (int i = 0; i < m; i++) {
            String q = wordsQuery[i];
            TrieNode curr = root;
            int bestIdx = root.bestIndex;
            
            for (int j = q.length() - 1; j >= 0; j--) {
                int idx = q.charAt(j) - 'a';
                if (curr.children[idx] == null) {
                    break;
                }
                curr = curr.children[idx];
                bestIdx = curr.bestIndex;
            }
            ans[i] = bestIdx;
        }
        
        return ans;
    }
}