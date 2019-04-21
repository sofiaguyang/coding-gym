package com.github.sofiaguyang.leetcode.k_diff_pairs_in_array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairsInArrayViaMapOrSetOnePass {
    public int findPairs(int[] nums, int k) {
        // Because absolute difference can never be negative...
        if (k < 0)
            return 0;

        int count = 0;

        if (k == 0) {
            Map<Integer, Integer> num2Count = new HashMap<>();
            for (int num : nums) {
                if (num2Count.containsKey(num) && num2Count.get(num) == 1)
                    count++;
                num2Count.computeIfPresent(num, (key, value) -> value + 1);
                num2Count.putIfAbsent(num, 1);
            }
            return count;
        }

        // If k > 0
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                if (set.contains(num - k)) count++;
                if (set.contains(num + k)) count++;
                set.add(num);
            }
        }
        return count;
    }
}
