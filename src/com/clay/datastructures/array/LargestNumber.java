package datastructures.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums = [10,2]
 * Output: "210"
 * <p>
 * Example 2:
 * Input:
 * nums = [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {

    public static void main(String[] args) {
//        int[] input = new int[]{10, 2};
        int[] input = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(input));
    }

    public static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] values = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(values, (val1, val2) -> (val2+val1).compareTo(val1+val2));

        if (values[0].equals("0")) {
            return "0";
        }

        for (String value : values) {
            sb.append(value);
        }
        return sb.toString();
    }
}
