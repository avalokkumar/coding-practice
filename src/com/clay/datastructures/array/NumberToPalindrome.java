package datastructures.array;

/**
 * Program to get the next smallest number which is a palindrome
 */
public class NumberToPalindrome {

    public static void main(String[] args) {
        int num = 1234; // 1331
        int num1 = 19872; // 19991

//        System.out.println(numberToPalindrome(num));
        System.out.println(numberToPalindrome(713322));
    }

    private static int numberToPalindrome(int num) {
        int temp = num;
        int temp2 = num;
        int len = 0;

        boolean canIncrementLeft = false;

        if (num % 10 == 0) {
            return num;
        }

        while (temp != 0) {
            temp /= 10;
            len += 1;
        }

        char[] values = new char[len];
        int i = len - 1;

        while (temp2 != 0) {
            values[i--] = (char) (temp2 % 10);
            temp2 /= 10;
        }

        int left = len / 2 - 1;
        int right = len / 2;

        while (left >= 0 && right < len) {
            if (values[left] == values[right]) {
                left--;
                right++;
            } else if (values[left] < values[right]) {
                values[left--] = values[right++];
                canIncrementLeft = true;
                break;
            } else {
                values[right--] = values[left++];
            }
        }

        if (canIncrementLeft) {
            while (left >= 0 && right < len) {
                if (values[left] != values[right]) {
                    values[right++] = values[left--];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < values.length; j++) {
            sb.append((int) values[j]);
        }

        return Integer.parseInt(sb.toString());
    }
}
