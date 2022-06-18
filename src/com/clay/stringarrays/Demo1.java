package stringarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class Demo1 {

	public static void main(String[] args) {
		String str = "adoiyklsett";
		System.out.println(checkUniqueStr(str));
	}

	private static boolean checkUniqueStr(String str) {
		
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(str.indexOf(c) == str.lastIndexOf(c)){
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		Map<String, Integer> ba = new HashMap<>();

		return flag;
	}
}
