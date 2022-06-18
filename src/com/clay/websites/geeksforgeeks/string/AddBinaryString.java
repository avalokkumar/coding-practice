package websites.geeksforgeeks.string;

//Add Binary Strings

/**
 * Given two strings s1 and s2 consisting of only ones and zeros,
 * return a string representing the sum of s1 and s2 when they are considered as binary numbers.
 * Input: s1 = "101", s2 = "1"
 * Output: "110"
 * Explanation: In base 10, “101” represents 5, and “1” represents 1. Their sum is 6, which is “110” in binary.
 */
public class AddBinaryString {

    public static void main(String[] args) {
//        System.out.println(addBinary("101", "1"));
        System.out.println(addBinary("1010", "10"));
    }

    private static String addBinary(String s, String s1) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = s.length() - 1;
        int j = s1.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += s.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += s1.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
