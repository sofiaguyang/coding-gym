package com.github.sofiaguyang.leetcode.k_diff_pairs_in_array

import com.google.common.primitives.Ints
import spock.lang.Specification
import spock.lang.Unroll


class KDiffPairsInArrayTest extends Specification {

    @Unroll
    def "Returns #expected k-diff pairs given nums=#nums and k=#k"() {
        given:
        def mapAndSetSolutionTwoPass = new KDiffPairsInArrayViaMapAndSetTwoPass()
        def mapOnlySolutionTwoPass = new KDiffPairsInArrayViaMapOnlyTwoPass()
        def mapOrSetOnePassSolution = new KDiffPairsInArrayViaMapOrSetOnePass()

        expect:
        mapAndSetSolutionTwoPass.findPairs(Ints.toArray(nums), k) == expected
        mapOnlySolutionTwoPass.findPairs(Ints.toArray(nums), k) == expected
        mapOrSetOnePassSolution.findPairs(Ints.toArray(nums), k) == expected

        where:
        nums            | k  || expected
        [3, 1, 4, 1, 5] | 2  || 2
        [1, 2, 3, 4, 5] | 1  || 4
        [1, 3, 1, 5, 4] | 0  || 1
        [1, 2, 3, 4, 5] | -1 || 0
        [-1, -2]        | 1   | 1
    }
}