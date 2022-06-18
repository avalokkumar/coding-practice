package array;

/**
 * Container With Most Water
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    //Brute force approach
    private static int maxArea(int[] height) {

        int maxVol = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                maxVol = Math.max(maxVol, temp);
            }
        }
        return maxVol;
    }

    public static int  maxArea2( int [] height) {
        int  start  =  0 ;
        int  end  =  height . length  -  1 ;
        int  result  =  0 ;
        while  (start  <  end) { // check start and end
            if  (height[start]  >=  height[end]) { //
                result  =  Math . max(result, (end  -  start)  *  height[end]);
                end -- ;
            }  else  {
                result  =  Math . max(result, (end  -  start)  *  height[start]);
                start ++ ;
            }
        }
        return  result;
    }

}
