package com.github.sofiaguyang.leetcode.isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStringsViaTrackingIndexUsingMap {
    public boolean isIsomorphic(String S, String T) {
        Map<Character, Integer> sToLastIndex = new HashMap<>();
        Map<Character, Integer> tToLastIndex = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char s = S.charAt(i);
            char t = T.charAt(i);
            if (!get(sToLastIndex, s).equals(get(tToLastIndex, t)))
                return false;
            sToLastIndex.put(s, i);
            tToLastIndex.put(t, i);
        }

        return true;
    }

    private Integer get(Map<Character, Integer> sToLastIndex, char s) {
        return sToLastIndex.getOrDefault(s, -1);
    }
}
