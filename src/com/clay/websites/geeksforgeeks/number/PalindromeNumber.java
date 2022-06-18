package websites.geeksforgeeks.number;

//Palindrome Number

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int n = 121;
        System.out.println(isPalindrome(n));
    }

    private static boolean isPalindrome(int n) {
        int rev = 0;
        int temp = n;
        if (n < 0) {
            return false;
        }
        if (n>0 && n%10 == 0) {
            return false;
        }

        while (temp != 0) {
            rev = rev*10 + temp%10;
            temp = temp/10;
        }
        return rev == n;
    }
}
