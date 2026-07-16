import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        
        int maxPoints = 0;
        
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 1;
            int localMax = 0;
            
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }
                
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;
                
                // Keep sign consistent (e.g., -1/-2 should be represented as 1/2)
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = Math.abs(dy); // Vertical line
                }
                
                String slope = dx + "/" + dy;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            maxPoints = Math.max(maxPoints, localMax + duplicate);
        }
        
        return maxPoints;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}