package array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Sorts {@code numbers} such that if you form a number {@code n}
 * by concatenating digits in order a[0]....a[size], it results being the
 * largest number possible.
 * <p/>
 * For example,
 * I/P: {54, 546, 548, 60}
 * O/P: {60, 548, 546, 54}, i.e, 6054854654
 * <p/>
 * I/P: {1, 34, 3, 98, 9, 76, 45, 4}
 * O/P: {9, 98, 76, 45, 4, 34, 3, 1}, i.e, 998764543431
 *
 * @param numbers input integer array
 * @return integer array where if you concatenate all its elements, you will get the largest number
 */
public class ArrangeNumbers {

    public static void main(String[] args) {
        Integer[] numbers = {54, 546, 548, 60};
        Arrays.sort(numbers, (num1, num2) -> Integer.parseInt(num1 + "" + num2) >= Integer.parseInt(num2 + "" + num1) ? -1 : 1);
        System.out.println(Arrays.toString(numbers));
    }
}
