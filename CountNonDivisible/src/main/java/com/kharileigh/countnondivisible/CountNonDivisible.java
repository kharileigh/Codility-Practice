/**
 *
 * @author kharileigh
 * < You are given an array A consisting of N integers.

For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.

For example, consider integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
For the following elements:

A[0] = 3, the non-divisors are: 2, 6,
A[1] = 1, the non-divisors are: 3, 2, 3, 6,
A[2] = 2, the non-divisors are: 3, 3, 6,
A[3] = 3, the non-divisors are: 2, 6,
A[4] = 6, there aren't any non-divisors.
Write a function:

class Solution { public int[] solution(int[] A); }

that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
the function should return [2, 4, 3, 2, 0], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..50,000];
each element of array A is an integer within the range [1..2 * N].
 */

package com.kharileigh.countnondivisible;

import java.util.*;

public class CountNonDivisible {

    public static void main(String[] args) {
        
        CountNonDivisible nonDivisors = new CountNonDivisible();
        
        int[] array = nonDivisors.solution(new int [] {3, 1, 2, 3, 6});
        
        // should return [2, 4, 3, 2, 0]
        for (int value : array) {
            System.out.println(value);
        }
        
    }
    
    
    // Return elements that are NOT Divisors of A[i]
    public int[] solution(int[] A) {
        
        // 1 : COUNT ELEMENTS - HASHMAP DATA STRUCTURE
        HashMap<Integer, Integer> elementCountMap = new HashMap<>();
        
        // map element to key, number of times it appears as its value in map
        for (int i = 0; i < A.length; i++) {
        
            // check if map contains current element first - if it doesn't add it with a value of 1
            if (elementCountMap.containsKey(A[i]) == false) {
                elementCountMap.put(A[i], 1);
                
            // if element already in map, increments its value 
            } else {
                elementCountMap.put(A[i], elementCountMap.get(A[i]) + 1);
            }
        }
    
        // 2 : COUNT NON-DIVISORS OF ELEMENTS - HASHMAP DATA STRUCTURE
        HashMap<Integer, Integer> nonDivisorsMap = new HashMap<>();
        
        // iterate through elementCountMap, check for divisors
        for (int num : elementCountMap.keySet()) {
        
            //check if num is a divisor
            int numOfDivisors = 0;
            int squareRootN = (int)Math.sqrt(num);
            
            for ( int i = 1; i <= squareRootN; i++) {
            
                if (num % i == 0) {
                    int divisor = num / i;
                    
                    if (elementCountMap.containsKey(i) == true) {
                        numOfDivisors = numOfDivisors + elementCountMap.get(i);
                    }
                    
                    if (divisor != i) {
                        numOfDivisors = numOfDivisors + elementCountMap.get(divisor);
                    }
                }
            }
            
            // place non-divisors in map
            int nonDivisors = A.length - numOfDivisors;
            nonDivisorsMap.put(num, nonDivisors);
        }
        
        // 3 : RETURN NUMBER OF NON-DIVISORS
        int[] numOfNonDivisors = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            numOfNonDivisors[i] = nonDivisorsMap.get(A[i]);
        }
        
        return numOfNonDivisors;
    }
}
