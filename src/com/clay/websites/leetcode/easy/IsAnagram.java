package websites.leetcode.easy;

public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagqaram"));
    }
    public static boolean isAnagram(String s, String t) {
        int[] charFrequencyS = getFrequency(s);
        int[] charFrequencyT = getFrequency(t);

        for (int i=0; i< 26; i++) {
            if (charFrequencyS[i] != charFrequencyT[i])  {
                return false;
            }
        }

        return true;
    }

    public static int[] getFrequency(String str) {

        int[] freq = new int[26];

        for(int i=0; i< str.length(); i++) {
            int index = (int) str.charAt(i) - 97;
            freq[index]++;
        }

        return freq;
    }
}
