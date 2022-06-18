package stringarrays;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 * Str 1 - abcderf
 * Str 2 - fedabcr
 */
public class Demo2 {

	public static void main(String[] args) {
		String str1 = "abcderf";
		String str2 = "fedabcr";

//		System.out.println(checkIsPermutation(str1, str2));
		int[] temp = new int[] {1,2,3,4,5,6};
		int[] t1 = Arrays.copyOfRange(temp, 2, 6);

		for (int i=0;i < t1.length; i++) {
			System.out.print(t1[i]+ " - ");
		}

	}

	private static boolean checkIsPermutation(String str1, String str2) {
		int count1 = countAscii(str1);
		int count2 = countAscii(str2);

		return count1 == count2;
	}

	private static int countAscii(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i);
		}
		return sum;
	}

}
