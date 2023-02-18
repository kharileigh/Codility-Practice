/**
 *
 * @author kharileigh
 * < A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
 */

package com.kharileigh.maxproductofthree;


public class MaxProductOfThree {
    
    public static void main(String[] args) {
        
        // should return 60
        System.out.println(new MaxProductOfThree().solution(new int[] {-3, 1, 2, -2, 5, 6}));
        
        // should return 20
        System.out.println(new MaxProductOfThree().solution(new int[] {4, 5, 1, 0}));
    }
    
    
    
    // to store 2 smallest numbers
    int[] smallestValue = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
    
    // to store 3 largest numbers
    int[] largestValue = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    
    
    // SOLUTION 
    public int solution(int[] A) {
        
        // for efficiency, iterating through once
        for (int value : A) {
            
            considerLargest(value);
            considerSmallest(value);
        }
        
        int product1 = largestValue[0] * largestValue[1] * largestValue[2];
        int product2 = largestValue[0] * smallestValue[0] * smallestValue[1];
        
 
        return Math.max(product1, product2);
    }
    
    
    // method to move smallest value to first index[0], and move next value to second index[1] (2 values only)
    private void considerSmallest(int a) {
        if (a < smallestValue[0]) {
            smallestValue[1] = smallestValue[0];
            smallestValue[0] = a;
            
        } else if (a < smallestValue[1]) {
            smallestValue[1] = a;
        }   
    }
    
    // method to move largest value to first index[0], second largest to second index[1] and third largest to third index[2]
    private void considerLargest(int b) {
        if (b > largestValue[0]) {
            largestValue[2] = largestValue[1];
            largestValue[1] = largestValue[0];
            largestValue[0] = b;
            
        } else if (b > largestValue[1]) {
            largestValue[2] = largestValue[1];
            largestValue[1] = b;
            
        } else if (b > largestValue[2]) {
            largestValue[2] = b;
        }
    
    }
}
