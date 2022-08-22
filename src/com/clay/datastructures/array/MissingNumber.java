package array;

import java.util.Random;

//How do you find the missing number in a given integer array of 1 to 100?
public class MissingNumber {

    public static void main(String[] args) {

        Random random = new Random();
        int[] nums = random.ints(99, 0, 99).toArray();

        for (int i: nums){
            System.out.println(""+i);
        }
    }
}
