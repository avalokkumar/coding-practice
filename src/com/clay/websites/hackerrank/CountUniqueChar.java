package websites.hackerrank;

//Write a program to check if a string have all unique characters. Print true if it does or false otherwise.
// Example:
// "person" - true
// "animals" - false


public class CountUniqueChar {
	
	private static boolean hasUniqueChars(String sample) {

		String str = sample.replace(" ", "").toLowerCase();
		int[] charCounts = getCharCount(str);
		for (int i = 0; i < charCounts.length; i++) {
			if(charCounts[i] !=0 && charCounts[i] > 1) {
				return false;
			}
		}
		return true;
	}

	private static int[] getCharCount(String str) {
		int[] count = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i);
			int offset = (int) 'a';
			int val = ch - offset;
			count[val]++;
		}
		return count;
	}

	public static void main(String[] args) {

		String sample = "Helpxcmka";
		System.out.println(hasUniqueChars(sample));
	}

}
