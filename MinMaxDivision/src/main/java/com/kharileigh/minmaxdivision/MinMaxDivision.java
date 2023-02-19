/**
 *
 * @author kharileigh
 * < You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.

You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

The large sum is the maximal sum of any block.

For example, you are given integers K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
The array can be divided, for example, into the following blocks:

[2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.

Write a function:

class Solution { public int solution(int K, int M, int[] A); }

that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.

For example, given K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and K are integers within the range [1..100,000];
M is an integer within the range [0..10,000];
each element of array A is an integer within the range [0..M].
 */

package com.kharileigh.minmaxdivision;


public class MinMaxDivision {

    public static void main(String[] args) {
        
        // should return 6
        System.out.println(new MinMaxDivision().solution(3, 5, new int[] {2, 1, 5, 1, 2, 2, 2}));
    }
    
    
    // Find Minimal Large Sum using Binary Search Algorithm so it can be fast
    public int solution(int K, int M, int[] A) {
        
        // 1 : GLOBAL VARIABLES
        int minSum = 0;
        int maxSum = 0;
        
        
        // 2 : Get maxSum & minSum of elements
        for (int i = 0; i < A.length; i++) {
            
            maxSum = maxSum + A[i];
            minSum = Math.max(minSum, A[i]);
        }
    
        // 3 : Store potential result
        int result = maxSum;
        
        
        // 4 : Binary Search for better sum
        while (minSum <= maxSum) {
        
            // define the mid sum
            int midSum = (minSum + maxSum) / 2;
            
            // check if mid is divisible
            boolean isDivisible = checkIfDivisible(midSum, K, A);
            
            // if true, try smaller
            if (isDivisible == true) {
                result = midSum;
                
                maxSum = midSum - 1;
            
            // if false, try larger
            } else {
                
                minSum = midSum + 1;
            }
        }
        
        return result;
    }
    
    
    // HELPER METHOD - check if can be divided using mid
    public boolean checkIfDivisible(int mid, int K, int[] A) {
        
        int numOfBlocks = K;
        int currentSumOfBlocks = 0;
        
        for (int i = 0; i < A.length; i++) {
        
            currentSumOfBlocks = currentSumOfBlocks + A[i];
            
            if (currentSumOfBlocks > mid) {
                numOfBlocks--;
                currentSumOfBlocks = A[i];
            }
            
            // if cannot find mid
            if (numOfBlocks == 0) {
                return false;
            }
        }
        
        // found mid
        return true;
    }
    
}
