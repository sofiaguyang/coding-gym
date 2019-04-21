package com.github.sofiaguyang.leetcode.median_of_two_sorted_arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length < B.length) {
            return findMedianSortedArrays(A, B, 0, A.length);
        }
        return findMedianSortedArrays(B, A, 0, B.length);
    }

    private double findMedianSortedArrays(int[] shorterArray, int[] longerArray, int L, int R) {
        int shorterArraySliceIndex = (L + R) / 2;
        int combinedLength = shorterArray.length + longerArray.length;
        int longerArraySliceIndex = (combinedLength + 1) / 2 - shorterArraySliceIndex; // +1 s.t. we can get extra elem if odd

        double shorterArrayHalf1Rep = get(shorterArray, shorterArraySliceIndex - 1);
        double shorterArrayHalf2Rep = get(shorterArray, shorterArraySliceIndex);
        double longerArrayHalf1Rep = get(longerArray, longerArraySliceIndex - 1);
        double longerArrayHalf2Rep = get(longerArray, longerArraySliceIndex);

        if (shorterArrayHalf1Rep <= longerArrayHalf2Rep && longerArrayHalf1Rep <= shorterArrayHalf2Rep) {
            if (combinedLength % 2 == 0) {
                return average(Math.max(shorterArrayHalf1Rep, longerArrayHalf1Rep), Math.min(shorterArrayHalf2Rep, longerArrayHalf2Rep));
            }
            return Math.max(shorterArrayHalf1Rep, longerArrayHalf1Rep);
        }

        if (longerArrayHalf1Rep > shorterArrayHalf1Rep) {
            return findMedianSortedArrays(shorterArray, longerArray, shorterArraySliceIndex + 1, R);
        }

        // shorterArrayHalf1Rep > longerArrayHalf2Rep
        return findMedianSortedArrays(shorterArray, longerArray, L, shorterArraySliceIndex - 1);
    }

    private double get(int[] array, int index) {
        if (index < 0)
            return Double.NEGATIVE_INFINITY;

        if (index >= array.length)
            return Double.POSITIVE_INFINITY;

        return array[index];
    }

    private double average(double x, double y) {
        return (x + y) / 2.0;
    }
}
