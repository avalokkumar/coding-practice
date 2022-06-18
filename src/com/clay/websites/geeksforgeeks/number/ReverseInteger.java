package websites.geeksforgeeks.number;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = 120;
        System.out.println(reverse(x));
    }

    private static int reverse(int x) {

        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && mod > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && mod < -8)) {
                return 0;
            }
            result = result * 10 + mod;
        }
        return result;
    }
}
