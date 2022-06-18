package others;

public class PalindromicNumber {
    public static void main(String[] args) {
        System.out.println(isPalindromic(-121));

    }

    private static boolean isPalindromic(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int temp = x;
        while (temp != 0) {
            reverse = temp % 10 + reverse * 10;
            temp /= 10;
        }
        return reverse == x;
    }
}
