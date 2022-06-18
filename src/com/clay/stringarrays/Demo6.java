package stringarrays;

/**
 * 
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2b1c5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You
 * can assume the string has only uppercase and lowercase letters (a - z).
 *
 * Ex: aabcccccaaa would become a2b1c5a3
 */
public class Demo6 {

	private static void getCompressedString(String input) {
		int c=1;
		for (int i = 0; i < input.length()-1; i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				c++;
			}else {
				System.out.print(input.charAt(i)+""+c);
				c=1;
			}
			
			if(i == input.length()-2) {
				System.out.print(input.charAt(i+1)+""+c);
			}
		}
	}

	public static void main(String[] args) {
		String input = "aasiiooppppmmmmml";

		getCompressedString(input);
	}
}
