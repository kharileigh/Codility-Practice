/**
 *
 * @author kharileigh
 * < An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
<For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */

package com.kharileigh.triangle;

import java.util.*;

public class Triangle {

    public static void main(String[] args) {
        
        // should return 1
        System.out.println(new Triangle().solution(new int[] {10, 2, 5, 1, 8, 20}));
        
        // should return 0
        System.out.println(new Triangle().solution(new int[] {10, 50, 5,1}));
    }
    
    
    public int solution(int[] A) {
        
        // check that minimum of 3 values are in array
        if (A.length < 3) {
            return 0;
        }
    
        // sort array first
        Arrays.sort(A);
        
        // iterate through array, two values ahead - triplets in each loop
        for (int i = 0; i < A.length -2; i++) {
            
            // cast to long so calculation is done on long
            if ((long)A[i] + A[i + 1] > A[i + 2]) {
                
                return 1;
            }
        }
        
        return 0;
    }
}
