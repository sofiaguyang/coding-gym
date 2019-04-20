package com.github.sofiaguyang.leetcode.two_sum

import spock.lang.Specification
import spock.lang.Unroll


class TwoSumTest extends Specification {

    @Unroll
    def "Returns #expected nums=#nums and target=#target"() {
        given:
        TwoSum twoSum = new TwoSum()

        expect:
        twoSum.twoSum(nums as int[], target) == expected as int[]

        where:
        nums                 | target || expected
        [2, 15, 11, 7]       | 9      || [0, 3]
        [3, 2, 4]            | 6      || [1, 2]
        [3, 4, 3]            | 6      || [0, 2]
        [0, 4, 3, 0]         | 0      || [0, 3]
        [-1, -2, -3, -4, -5] | -8     || [2, 4]
    }
}