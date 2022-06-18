package websites.leetcode.medium;

public class Sample {


    //program to initialise 2D boolean array
    public static boolean[][] init2DArray(int rows, int columns) {
        boolean[][] array = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = false;
            }
        }
        return array;
    }
    public static int countPositive(int[] arr) {

        String s = "dsad";
        int count = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] > 0) {
                count++;
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                i = 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
