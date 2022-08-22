package datastructures.binary;

import java.math.BigInteger;

public class NumberOf1Bits {

    public static void main(String[] args) {

        System.out.println(hammingWeight(1011));
    }

    public static int hammingWeight2(int n) {

        int count = 0;
        while (n != 0) {
            count += n%2;
            n = n >> 1;
        }
        return count;
    }

    public static int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count+=1;
        }
        return count;
    }

}
