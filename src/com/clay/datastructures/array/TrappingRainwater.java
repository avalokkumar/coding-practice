package datastructures.array;

/**
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrappingRainwater {

    public static void main(String[] args) {
//        int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heights = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trapOptimized(heights));
    }

    public static int trapOptimized(int[] height) {

        if (height.length == 0) {
            return 0;
        }
        int sum = 0;
        int i = 0;
        int j = height.length - 1;

        int maxLeft = height[i];
        int maxRight = height[j];

        while (i < j) {
            if (maxLeft < maxRight) {
                i++;
                maxLeft = Math.max(maxLeft, height[i]);
                sum += Math.max(maxLeft - height[i], 0);
            } else {
                j--;
                maxRight = Math.max(maxRight, height[j]);
                sum += Math.max(maxRight - height[j], 0);
            }
        }

        return sum;
    }

    public static int trap(int[] heights) {
        int[] maxLeft = new int[heights.length];
        int[] maxRight = new int[heights.length];
        int result = 0;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            maxLeft[i] = max;
            if (heights[i] >= max) {
                max = heights[i];
            }
        }
        max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            maxRight[i] = max;
            if (heights[i] >= max) {
                max = heights[i];
            }
        }

        for (int i = 0; i < heights.length; i++) {
            int minOfMaxHeight = Math.min(maxLeft[i], maxRight[i]);
            int diff = minOfMaxHeight - heights[i];
            if (diff > 0) {
                result += diff;
            }
        }
        return result;
    }
}
