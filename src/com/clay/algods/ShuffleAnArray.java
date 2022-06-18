package algods;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Shuffle a set of numbers without duplicates.
 */
public class ShuffleAnArray {

    private static int[] arr;

    public ShuffleAnArray(int[] nums) {
        arr = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public static int[] reset() {
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public static int[] shuffle() {

        int[] tempArr = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < tempArr.length; i++) {
            int randomIndex = (int) (Math.random() * tempArr.length);
            int element = tempArr[i];
            tempArr[i] = tempArr[randomIndex];
            tempArr[randomIndex] = element;
        }

        return tempArr;
    }
    private static void printArr(int[] arrVals){
        for (int i: arrVals) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {

        Scanner s1 = new Scanner(System.in);
        int num = s1.nextInt();
        arr = new int[num];
        for (int i = 0; i< num; i++){
            arr[i] = s1.nextInt();
        }

        for (int i = 0; i< 10; i++){
            printArr(shuffle());
            reset();
        }
    }
    // 1 3 5 6 10 22 67 12 34 4


}
