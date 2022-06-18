package websites.geeksforgeeks.medium;

/**
 * Changing Base
 * Given an integer (represented as a string) under base b1, convert it to base b2
 */
public class ChangingBase {
    public static void main(String[] args) {
        System.out.println(changeBase("101", 2, 10));
        System.out.println(changeBase("101", 10, 2));
    }

    //Method to convert integer value from base b1 to b2
    public static String changeBase(String num, int b1, int b2) {
        int n = num.length();
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = num.charAt(i) - '0';
        }
        int[] resArr = new int[n];
        int i = 0;
        while (i < n) {
            int j = 0;
            int sum = 0;
            while (j < n) {
                sum += numArr[j] * Math.pow(b1, n - j - 1);
                j++;
            }
            int k = 0;
            while (sum > 0) {
                resArr[i + k] = sum % b2;
                sum = sum / b2;
                k++;
            }
            i += k;
        }
        StringBuilder sb = new StringBuilder();
        for (int l = n - 1; l >= 0; l--) {
            sb.append(resArr[l]);
        }
        return sb.toString();
    }

}
