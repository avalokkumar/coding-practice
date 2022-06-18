package websites.leetcode.medium;

public class FindMaxZeroGap {
    public static void main(String[] args) {
     /*   String S = "id,name,age, act";
        String[] val = S.split(S.indexOf(0));

        for (String s : val) {
            System.out.println(s);
        }*/
//        System.out.println(getBinary(256));
    }

    //program to convert decimal to binary
 /*   public static String getBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }*/

    //program to split csv into an array of strings
    private static int getBinary(int num) {
        int binary = 0;
        int remainder = 0;
        int i = 1;

        while (num != 0) {
            remainder = num % 2;
            num = num / 2;
            binary += remainder * i;
            i = i * 10;
        }

        return binary;
    }

    public static int findMaxGap(int num) {

        return -1;
    }
}
