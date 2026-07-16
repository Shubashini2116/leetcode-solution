import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 as the initial base index for calculating valid lengths
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Push the index of the open parenthesis
                stack.push(i);
            } else {
                // Pop the last open parenthesis index or base index
                stack.pop();
                
                if (stack.isEmpty()) {
                    // If the stack is empty, it means this ')' has no matching '('
                    // We push the current index as the new base boundary
                    stack.push(i);
                } else {
                    // Calculate the length of the current valid substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}