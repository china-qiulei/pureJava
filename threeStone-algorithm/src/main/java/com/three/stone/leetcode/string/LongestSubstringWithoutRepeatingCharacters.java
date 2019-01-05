package com.three.stone.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                /**
                 * 此处是关键，i的新值不能比当前值更小
                 */
                i = Math.max(map.get(s.charAt(j) + 1), i);
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
        lengthOfLongestSubstring("tmmzuxt");
    }


}
