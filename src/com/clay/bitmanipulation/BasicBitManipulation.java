package com.clay.bitmanipulation;

//* Fundamental bit manipulation operations you must know Time Complexity: O(1)

/**
 * @author Clay
 * @date 2019/3/1
 * @time 10:33
 * Basic Bit Manipulation
 */
public class BasicBitManipulation {

    public static void main(String[] args) {

//         1.   Get the last bit of an integer
        System.out.println(getLastBit(1));
        System.out.println(getLastBit(2));
        System.out.println(getLastBit(3));
        System.out.println(getLastBit(4));
        //2. Sets the i'th bit to 1
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);


        //set ith bit to 1
        System.out.println(setBit(2, 1));

        //3.  Clears the i'th bit
        System.out.println(1 << 1);

        //4. Check if i'th bit is set
//        System.out.println(1 << 1);
        System.out.println(isSet(2, 1));

        ////  Toggles the i'th bit from 0 -> 1 or 1 -> 0
        System.out.println(toggleBit(2, 1));



    }

    private static int getLastBit(int i) {
        return i & 1;
    }

    //  Sets the i'th bit to 1
    public  static  int  setBit ( int  set , int  i ) {
        return  set  |  ( 1  <<  i);
    }

    //100
    //  Checks if the i'th is set
    public  static  boolean  isSet ( int  set , int  i ) {
        return  (set  &  ( 1  <<  i))  !=  0 ;
    }

    //  Sets the i'th bit to zero
    public  static  int  clearBit ( int  set , int  i ) {
        return  set  &  ~ ( 1  <<  i);
    }

    //  Toggles the i'th bit from 0 -> 1 or 1 -> 0
    public  static  int  toggleBit ( int  set , int  i ) {
        return  set  ^  ( 1  <<  i);
    }

    //  Returns a number with the first n bits set to 1
    public  static  int  setAll ( int  n ) {
        return  ( 1  <<  n)  -  1 ;
    }

    //  Verifies if a number n is a power of two
    public  static  boolean  isPowerOfTwo ( int  n ) {
        return  n  >  0  &&  (n  &  (n  -  1 ))  ==  0 ;
    }
}
