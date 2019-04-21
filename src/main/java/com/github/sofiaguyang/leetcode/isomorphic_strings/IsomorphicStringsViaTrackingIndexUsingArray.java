package com.github.sofiaguyang.leetcode.isomorphic_strings;

public class IsomorphicStringsViaTrackingIndexUsingArray {
    public boolean isIsomorphic(String s, String t) {
        int[] sArray = new int[128], tArray = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if (sArray[s.charAt(i)] != tArray[t.charAt(i)]) return false;
            sArray[s.charAt(i)] = tArray[t.charAt(i)] = i+1; // +1 to diff it from default 0 value
        }

        return true;
    }
}
