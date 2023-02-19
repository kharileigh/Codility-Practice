/**
 *
 * @author kharileigh
 * < A non-empty array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:

double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has a sum of greater than 17.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−10,000..10,000].
 */

package com.kharileigh.maxdoubleslicesum;


public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        
        // should return 17
        System.out.println(new MaxDoubleSliceSum().solution(new int[] {3, 2, 6, -1, 4, 5, -1, 2}));
    }
    
    
    // double slice : 0 ≤ X < Y < Z < N
    // sum of double slice : A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1]
    // (X, Y, Z)
    // split at Y - find maxLeft & maxRight (contiguous sequence, only need ending index of both)
    public int solution(int[] A) {
        
        // GLOBAL VARIABLES 
        int maxLeftSide[] = new int[A.length];
        int maxRightSide[] = new int[A.length];
        
        
        // 1 : LEFT SIDE
        for (int i = 1; i < A.length; i++) {
            maxLeftSide[i] = Math.max(0, maxLeftSide[i - 1] + A[i]);
        }
        
        
        // 2. RIGHT SIDE
        for (int i = A.length - 2; i >= 0; i--) {
            maxRightSide[i] = Math.max(0, maxRightSide[i + 1] + A[i]);
        }
        
        
        // 3. FIND MAXIMUM OF LEFT & RIGHT SIDE
        int maxDoubleSliceSum = 0;
        for (int i = 1; i < A.length - 1; i++) {
        
            if (maxLeftSide[i - 1] + maxRightSide[i + 1] > maxDoubleSliceSum) {
                maxDoubleSliceSum = maxLeftSide[i - 1] + maxRightSide[ i + 1];
            }
        }
    
        return maxDoubleSliceSum;
    }
}
