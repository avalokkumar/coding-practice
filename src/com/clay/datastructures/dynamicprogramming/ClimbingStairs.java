package datastructures.dynamicprogramming;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs2(2));
    }

    public static int climbStairs2(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2); //1+
    }

    public static int climbStairs(int n) {
        int first = 1, second = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = first;
            first = first + second;
            second = temp;
        }

        return first;
    }
}
