class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
                // Check if there is an overlap along both X-axis and Y-axis
                        return (rec1[0] < rec2[2] && rec1[2] > rec2[0]) && // X-axis overlap
                                       (rec1[1] < rec2[3] && rec1[3] > rec2[1]);   // Y-axis overlap
                                           }
                                           }
