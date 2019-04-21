package com.github.sofiaguyang.leetcode.k_diff_pairs_in_array;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArrayViaMapOnlyTwoPass {
    public int findPairs(int[] nums, int k) {
        // Because absolute difference can never be negative...
        if (k < 0)
            return 0;

        // Count occurrences
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            num2Count.computeIfPresent(num, (key, value) -> value + 1);
            num2Count.putIfAbsent(num, 1);
        }

        int count = 0;

        // If k == 0, just count those with more than 1 occurrence
        if (k == 0) {
            for (Map.Entry<Integer, Integer> entry : num2Count.entrySet()) {
                if (entry.getValue() > 1)
                    count++;
            }
            return count;
        }

        // If k>0, just count if partner found
        for (Map.Entry<Integer, Integer> entry : num2Count.entrySet()) {
            int partner = entry.getKey() + k;
            if (num2Count.containsKey(partner))
                count++;
        }

        return count;
    }
}
