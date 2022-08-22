package websites.leetcode.medium;

import java.util.*;

/**
 *Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagram {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> values : result) {
            System.out.print("[");
            for (String value : values) {
                System.out.print(value + ",");
            }
            System.out.println("]");
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if(strs.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        if (strs.length == 1) {
            result.add(Collections.singletonList(strs[0]));
            return result;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] hash = new char[26];
            for(char c: s.toCharArray()){
                hash[c-'a']++;
            }
            String str=new String(hash);
            map.computeIfAbsent(str, k -> new ArrayList<>());
            map.get(str).add(s);
        }

        result.addAll(map.values());

        return result;
    }

    public static int[] getFrequency(String str) {

        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int index = (int) str.charAt(i) - 97;
            freq[index]++;
        }

        return freq;
    }
}
