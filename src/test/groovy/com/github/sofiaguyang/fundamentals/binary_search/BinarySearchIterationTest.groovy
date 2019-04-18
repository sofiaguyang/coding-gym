package com.github.sofiaguyang.fundamentals.binary_search


import com.google.common.primitives.Ints
import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchIterationTest extends Specification {
    @Unroll
    def "returns #expectedResult given nums=#nums and target=#target"() {
        given:
        def binarySearchIteration = new BinarySearchIteration()

        expect:
        binarySearchIteration.search(Ints.toArray(nums), target) == expectedResult

        where:
        nums                 | target || expectedResult
        [-1, 0, 3, 5, 9, 12] | 2      || -1
        [-1, 0, 3, 5, 9, 12] | 13     || -1
        [-1, 0, 3, 5, 9, 12] | 9      || 4
        [-1, 0, 3, 5, 9, 12] | 12     || 5
    }
}