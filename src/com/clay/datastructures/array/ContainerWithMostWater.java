package array;

/**
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] height) {

        int beg =0;
        int end = height.length-1;
        int maxVol = 0;

        while (beg < end) {

            int minHeight = Math.min(height[beg], height[end]);
            maxVol = Math.max(maxVol, minHeight * (end-beg));

            if (height[beg] < height[end]) {
                beg++;
            } else {
                end--;
            }
        }
        return maxVol;
    }
}
