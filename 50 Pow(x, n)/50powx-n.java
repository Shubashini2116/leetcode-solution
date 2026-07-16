public class Solution {
    public double myPow(double x, int n) {
        // Convert n to a long to handle Integer.MIN_VALUE safely
        long N = n;
        
        // If the exponent is negative, invert the base and make the exponent positive
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        // Iterative binary exponentiation
        while (N > 0) {
            // If N is odd, multiply the current product into the result
            if ((N % 2) == 1) {
                result *= currentProduct;
            }
            // Square the base
            currentProduct *= currentProduct;
            // Divide the power by 2
            N /= 2;
        }
        
        return result;
    }
}