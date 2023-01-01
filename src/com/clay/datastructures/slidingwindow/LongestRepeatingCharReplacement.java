package datastructures.slidingwindow;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }


    public static int characterReplacement(String s, int k) {
        int[] charCount = new int[26];

        int maxFreq = 0;
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);

            charCount[key - 'A']++;
            maxFreq = Math.max(maxFreq, charCount[key - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    /*public static int characterReplacement(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxFreq = 0;
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);

            charMap.put(key, 1 + charMap.getOrDefault(key, 0));

            maxFreq = Math.max(maxFreq, charMap.get(key));

            while ((right - left + 1) - maxFreq > k) {
                left++;
                charMap.put(key, key - 1);
            }

            res = Math.max(res, right - left+1);
        }

        return res;
    }*/
}
