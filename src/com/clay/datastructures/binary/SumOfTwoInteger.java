package datastructures.binary;

/**
 * 371. Sum of Two Integers
 * Given two integers a and b, return the sum of the two integers without using the operators + and -
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *
 */
public class SumOfTwoInteger {

    public static void main(String[] args) {
        System.out.println(getSum(11,22));
    }

    public static int getSum(int a, int b) {

        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}
