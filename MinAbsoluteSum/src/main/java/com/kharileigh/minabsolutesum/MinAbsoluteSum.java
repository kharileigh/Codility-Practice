/**
 *
 * @author kharileigh
 * < For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:

val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|

(Assume that the sum of zero elements equals zero.)

For a given array A, we are looking for such a sequence S that minimizes val(A,S).

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

For example, given array:

  A[0] =  1
  A[1] =  5
  A[2] =  2
  A[3] = -2
your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..20,000];
each element of array A is an integer within the range [−100..100].
 */

package com.kharileigh.minabsolutesum;

import java.util.*;

public class MinAbsoluteSum {

    public static void main(String[] args) {
        
        // should return 0
        System.out.println(new MinAbsoluteSum().solution(new int[] {1, 5, 2, -2}));
    }
    
    // Find MINIMUM VALUE of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}
    public int solution(int[] A) {
        
        
        // 1 : STORE COUNT OF EACH VALUE SEEN 
        Map<Integer, Integer> countForValues = new HashMap<>();
        
        // 2 : CALCULATE SUM OF ABSOLUTE VALUES
        int sum = 0;
        for (int value : A) {
        
            int absoluteValue = Math.abs(value);
            sum += absoluteValue;
            
            // add absolute values to map - increment value if already in map
            if (countForValues.containsKey(absoluteValue)) {
                
                countForValues.put(absoluteValue, countForValues.get(absoluteValue) + 1);
            
            // add new value to map
            } else {
            
                countForValues.put(absoluteValue, 1);
            }
        }
        
        
        // 3 : CALCULATE CENTRE VALUE - use float to cover edge case of odd number
        float centreValue = sum / 2f;
        
        
        // 4 : FIND RANGE TO GO UP TO - floor of centreValue
        int range = (int)Math.floor(centreValue);
        
        
        // 5 : STORE RESULTS IN ARRAY
        int[] results = new int[range + 1];
        results[0] = 0;
        
        
        // for all other values, put -1
        for (int i = 1; i < results.length; i++) {
            results[i] = -1;
        }
        
        
        // 6 : ITERATE THROUGH ABSOLUTE VALUES IN MAP
        for (int value : countForValues.keySet()) {
            
            int countForAbsolutes = countForValues.get(value);
            results[0] = countForAbsolutes;
            
            for (int i = 0; i < results.length; i++) {
                if (results[i] >= 0) {
                    results[i] = countForAbsolutes;
                    
                } else {
                    if (i - value >= 0) {
                        results[i] = results[i - value] - 1;
                    }
                }
            }
        }
       
        
        
        // iterate from end of array to find latest value that has been marked
        for (int i = range; i >= 0; i--) {
        
            if (results[i] > 0) {
                return (int)((centreValue - i) * 2);
            }
        }
        
    
        return -1;
    }
}
