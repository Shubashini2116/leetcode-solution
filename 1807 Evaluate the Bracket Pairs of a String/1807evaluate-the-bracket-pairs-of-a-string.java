import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
            // Step 1: Store the knowledge key-value pairs in a HashMap for O(1) lookup
                    Map<String, String> map = new HashMap<>();
                            for (List<String> pair : knowledge) {
                                        map.put(pair.get(0), pair.get(1));
                                                }

                                                        StringBuilder result = new StringBuilder();
                                                                StringBuilder key = new StringBuilder();
                                                                        boolean insideBracket = false;

                                                                                // Step 2: Traverse the string character by character
                                                                                        for (char c : s.toCharArray()) {
                                                                                                    if (c == '(') {
                                                                                                                    insideBracket = true;
                                                                                                                                } else if (c == ')') {
                                                                                                                                                insideBracket = false;
                                                                                                                                                                // Replace key with mapped value, or '?' if not present
                                                                                                                                                                                String keyStr = key.toString();
                                                                                                                                                                                                result.append(map.getOrDefault(keyStr, "?"));
                                                                                                                                                                                                                key.setLength(0); // Clear key for the next bracket pair
                                                                                                                                                                                                                            } else if (insideBracket) {
                                                                                                                                                                                                                                            key.append(c);
                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                                        result.append(c);
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                    return result.toString();
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        }