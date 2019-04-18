package com.github.sofiaguyang.fundamentals.binary_search;

class BinarySearchIteration {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (true) {
            if(l > r)
                return -1;

            int m = (l + r) / 2;

            if(target == nums[m])
                return m;

            if(target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }
}
