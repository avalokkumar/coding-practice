package websites.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

//3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

/*
	Input: s = "abcabcbb"
	Output: 3

	Input: s = "cbbd"
	Output: "bb"
	Explanation: The answer is "abc", with the length of 3.
 */

public class LengthOfLongestSubstring {

	private static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 0) {
			return 0;
		}

		int count = 0, j = 0, lc = 1;

		for (int i = 1; i < s.length(); i++) {
			char firstCh = s.charAt(i);
			String maxSubstr = s.substring(j, i);
			if (match(maxSubstr, firstCh)) {
				lc = 1;
				j = i;
			} else {
				lc++;
			}

			if (count < lc) {
				count = lc;
			}
		}

		return count;
	}

	private static boolean match(String maxSubstr, char firstCh) {
		for (int i = 0; i < maxSubstr.length(); i++) {
			if (maxSubstr.charAt(i) == firstCh) {
				return true;
			}
		}
		return false;
	}

	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		int i =0, j=0;
		Set<Character> set = new HashSet<>();
		int max=0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			}
			else {
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}

	public static void main(String[] args) {
//		String str = new Scanner(System.in).nextLine();
//		System.out.println(lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(lengthOfLongestSubstring2("abcabcbb"));
//		System.out.println(lengthOfLongestSubstring2("bbbbb"));
		System.out.println(lengthOfLongestSubstring2("pwwkew"));
	}
}
//"abcabcbb"