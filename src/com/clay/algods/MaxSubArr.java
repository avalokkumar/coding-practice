package algods;

public class MaxSubArr {

    private static int getMaxSubArr(int[] arr) {
        int max = -99999, maxSoFar = -9999;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, max);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 7, 1, -9, 9, -4};
//        int[] arr = {-9, 1};
        int[] arr = new int[]{-2,-3, 4,-1,-2,1,5,-3};

        System.out.println(getMaxSubArr(arr));
    }

}
