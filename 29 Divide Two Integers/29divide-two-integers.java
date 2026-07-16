public class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // True if the signs are different, meaning the result will be negative
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to absolute values using long to prevent overflow during calculations
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // Shift and subtract loop
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int count = 1;

            // Shift left until tempDivisor is just smaller than or equal to absDividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                count <<= 1;
            }

            // Subtract the largest shifted divisor chunk found from the dividend
            absDividend -= tempDivisor;
            // Add the matching multiplier count to the result
            result += count;
        }

        return isNegative ? -result : result;
    }
}