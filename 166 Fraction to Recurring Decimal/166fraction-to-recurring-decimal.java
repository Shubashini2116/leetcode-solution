import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        
        // Handle negative result sign
        if ((numerator < 0) ^ (denominator < 0)) {
            res.append("-");
        }
        
        // Use long to prevent integer overflow (e.g., Integer.MIN_VALUE / -1)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Integer part
        res.append(num / den);
        long remainder = num % den;
        
        if (remainder == 0) {
            return res.toString();
        }
        
        // Fractional part
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        
        while (remainder != 0) {
            // If the remainder is already seen, it's a repeating fraction
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            
            // Record the position of the current remainder
            map.put(remainder, res.length());
            
            remainder *= 10;
            res.append(remainder / den);
            remainder %= den;
        }
        
        return res.toString();
    }
}