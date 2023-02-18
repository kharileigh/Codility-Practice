/**
 *
 * @author kharileigh
 * < A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
 */


package com.kharileigh.permcheck;

import java.util.*;

public class PermCheck {

    public static void main(String[] args) {
        
        PermCheck permCheck = new PermCheck();
        
        // should return 1
        System.out.println(permCheck.solution(new int[] {4, 1, 3, 2}));
    }
    
    public int solution(int[] A) {
    
        // hashset for maximum efficiency, does not need to iterate through entire group of values
        HashSet<Integer> numsInArray = new HashSet<Integer>();
        
        // range must start at 1, add each element in array to hashset
        for (int i = 1; i <= A.length; i++) {
        
            numsInArray.add(i);
        }
        
        
        // iterate through array 
        for (int value : A) {
            
            // if doesn't contain - not a permutation 
            if (!numsInArray.contains(value)) {
                return 0;
                
            // if it is, remove it
            } else {
                numsInArray.remove(value);
            }   
        }
        
        
        // check if hash set is empty, if it is return 1, else 0
        return numsInArray.isEmpty() ? 1 : 0;
    }
}
