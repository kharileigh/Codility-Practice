/**
 *
 * @author kharileigh
 * < A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
 */

package com.kharileigh.minavgtwoslice;


public class MinAvgTwoSlice {

    public static void main(String[] args) {
        
        MinAvgTwoSlice minAvg = new MinAvgTwoSlice();
        
        // should return 1
        System.out.println(minAvg.solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }
    
    public int solution(int[] A) {
        
        int indexOfMinOf2 = -1;
        int minSumOf2 = Integer.MAX_VALUE;
        
        int indexOfMinOf3 = -1;
        int minSumOf3 = Integer.MAX_VALUE;
        
        // iterate through to find index for sets of 2
        for (int i = 0; i < A.length - 1; i++) {
            
            int value1 = A[i];
            int value2 = A[i + 1];
            int sumOf2 = value1 + value2;
            
            if (sumOf2 < minSumOf2) {
                
                minSumOf2 = sumOf2;
                indexOfMinOf2 = i;
            }
            
            // to find index for sets of 3
            if (i < A.length - 2) {
            
                value1 = A[i];
                value2 = A[i + 1];
                
                int value3 = A[i + 2];
                int sumOf3 = value1 + value2 + value3;
                
                if (sumOf3 < minSumOf3) {
                    
                    minSumOf3 = sumOf3;
                    indexOfMinOf3 = i;
                }
                
            }
        }
        
        
        if (indexOfMinOf3 == -1) {
            
            return indexOfMinOf2;
            
        } 
        
        double avgOf2 = (double)minSumOf2 / 2;
        double avgOf3 = (double) minSumOf3 / 3;

        if (avgOf2 < avgOf3) {
            return indexOfMinOf2;
        }

        if (avgOf3 < avgOf2) {
            return indexOfMinOf3;
        }
        
        return Math.min(indexOfMinOf2, indexOfMinOf3);
        
    }
    
}
