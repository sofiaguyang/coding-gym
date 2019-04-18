package com.github.sofiaguyang.fundamentals.binary_search;

class BinarySearchRecursion {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        if (l > r)
            return -1;

        int m = (l + r) / 2;

        if (target == nums[m])
            return m;

        if (target > nums[m]) {
            return search(nums, m + 1, r, target);
        }

        return search(nums, l, m - 1, target);
    }
}
