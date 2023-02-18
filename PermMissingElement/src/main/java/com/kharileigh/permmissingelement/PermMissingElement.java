/**
 *
 * @author kharileigh

An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
 */

package com.kharileigh.permmissingelement;

import java.util.*;

public class PermMissingElement {

    public static void main(String[] args) {
        
        // should return 4
        System.out.println(new PermMissingElement().solution(new int[] {2, 3, 1, 5}));
    }
    
    
    public int solution(int[] A) {
        
        // hash set used to iterate to find missing element with maximum efficiency
        HashSet<Integer> listOfValues = new HashSet<Integer>();
        
        // put every value in array from to array list
        for (int i = 1; i <= A.length + 1; i++) {
        
            listOfValues.add(i);
        }
        
        // iterate through Array A once, remove Object from list
        for (int i = 0; i < A.length; i++) {
            
            listOfValues.remove((Integer)A[i]);
        }
        
    
        return listOfValues.iterator().next();
    }
}
