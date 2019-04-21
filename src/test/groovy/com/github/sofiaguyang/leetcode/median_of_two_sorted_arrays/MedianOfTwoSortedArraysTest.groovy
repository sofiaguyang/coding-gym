package com.github.sofiaguyang.leetcode.median_of_two_sorted_arrays

import com.google.common.primitives.Ints
import spock.lang.Specification
import spock.lang.Unroll


class MedianOfTwoSortedArraysTest extends Specification {

    @Unroll
    def "Returns median=#expected of two sorted arrays #nums1 and #nums2"() {
        given:
        def solution = new MedianOfTwoSortedArrays()

        expect:
        solution.findMedianSortedArrays(Ints.toArray(nums1), Ints.toArray(nums2)) == expected

        where:
        nums1               | nums2            || expected
        [1, 2, 3, 6, 7, 11] | [4, 5, 8, 9, 10] || 6
        [1, 2]              | [3, 4]           || 2.5
        [3]                 | [1, 2, 4, 5, 6]  || 3.5
        [1, 2, 4, 5, 6]     | [3]              || 3.5
        []                  | [1]              || 1
        [3]                 | [-2, -1]         || -1
    }
}