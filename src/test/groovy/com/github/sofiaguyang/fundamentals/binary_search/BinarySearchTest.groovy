package com.github.sofiaguyang.fundamentals.binary_search


import com.google.common.primitives.Ints
import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchTest extends Specification {
    @Unroll
    def "recursion returns #expectedResult given nums=#nums and target=#target"() {
        given:
        def binarySearchRecursion = new BinarySearchRecursion()
        def binarySearchIteration = new BinarySearchIteration()

        and:
        def numsArray = Ints.toArray(nums)

        expect:
        binarySearchRecursion.search(numsArray, target) == expectedResult
        binarySearchIteration.search(numsArray, target) == expectedResult

        where:
        nums                 | target || expectedResult
        [-1, 0, 3, 5, 9, 12] | 2      || -1
        [-1, 0, 3, 5, 9, 12] | 13     || -1
        [-1, 0, 3, 5, 9, 12] | 9      || 4
        [-1, 0, 3, 5, 9, 12] | 12     || 5
    }
}