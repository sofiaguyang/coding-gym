package com.github.sofiaguyang.leetcode.isomorphic_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStringsViaTrackingMappedChar {
    public boolean isIsomorphic(String S, String T) {
        Map<Character, Character> s2t = new HashMap<>();
        Set<Character> alreadyMapped = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            char s = S.charAt(i);
            char t = T.charAt(i);
            if (s2t.containsKey(s)) {
                if (s2t.get(s) != t)
                    return false;
            } else {
                if (alreadyMapped.contains(t))
                    return false; // No two characters can map to the same
                s2t.put(s, t);
                alreadyMapped.add(t);
            }
        }
        return true;
    }
}
