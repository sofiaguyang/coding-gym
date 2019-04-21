package com.github.sofiaguyang.fundamentals.binary_search


import com.google.common.primitives.Ints
import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchTest extends Specification {
    @Unroll
    def "Returns #expected given nums=#nums and target=#target"() {
        given:
        def recursiveSolution = new BinarySearchRecursion()
        def iterativeSolution = new BinarySearchIteration()

        and:
        def numsArray = Ints.toArray(nums)

        expect:
        recursiveSolution.search(numsArray, target) == expected
        iterativeSolution.search(numsArray, target) == expected

        where:
        nums                 | target || expected
        [-1, 0, 3, 5, 9, 12] | 2      || -1
        [-1, 0, 3, 5, 9, 12] | 13     || -1
        [-1, 0, 3, 5, 9, 12] | 9      || 4
        [-1, 0, 3, 5, 9, 12] | 12     || 5
    }
}