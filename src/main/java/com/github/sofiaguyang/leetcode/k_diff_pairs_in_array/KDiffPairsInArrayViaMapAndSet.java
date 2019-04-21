package com.github.sofiaguyang.leetcode.k_diff_pairs_in_array;

import java.util.*;

public class KDiffPairsInArrayViaMapAndSet {
    public int findPairs(int[] nums, int k) {
        // Because absolute difference can never be negative
        if(k < 0)
            return 0;

        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            num2Count.computeIfPresent(num, (key, value) -> value + 1);
            num2Count.putIfAbsent(num, 1);
        }

        Set<Pair> pairSet = new HashSet<>();
        for (int num : nums) {
            int partner = num + k;
            int partnerCount = num2Count.getOrDefault(partner, 0);
            if (partner == num && partnerCount > 1)
                pairSet.add(new Pair(num, partner));
            else if (partner != num && partnerCount > 0)
                pairSet.add(new Pair(num, partner));
        }

//        System.out.println("pairSet = " + pairSet);

        return pairSet.size();
    }

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Pair{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }
}
