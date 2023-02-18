/**
 *
 * @author kharileigh
 * 
 * < You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
 */

package com.kharileigh.maxcounters;


public class MaxCounters {

    public static void main(String[] args) {
        
        MaxCounters maxCounters = new MaxCounters();
        
        int[] resultOfCount = maxCounters.solution(5, new int[] {3, 4, 4, 6, 1, 4, 4});
        
        // print every value - should return [3, 2, 2, 4, 2]
        for (int value : resultOfCount) {
            System.out.println(value);
        }
    }
    
    
    
    public int[] solution(int N, int[] A) {
    
        int minValue = 0;
        int maxValue = 0;
        
        
        // array counters set to given number
        int[] counters = new int[N];
        
        
        for (int i = 0; i < A.length; i++) {
        
            // get operation
            int operation = A[i];
            if (operation == N + 1) {
            
                // MAX VALUE OPERATION
                minValue = maxValue;
                
                
            } else {
                
                // INCREMENT OPERATION
                operation--;
                
                // if value is currently less than minValue, set it to minValue plus the increase
                counters[operation] = Math.max(counters[operation] + 1, minValue + 1);
                
                // update maxValue from what it is currently is to the updated value of 1 added to it, or the minValue + 1
                maxValue = Math.max(maxValue, counters[operation]);
            }
        }
        
        // iterate through Array to ensure counters that have not been increased in max value step, will be brought up 
        for (int i = 0; i < counters.length; i++) {
            
            counters[i] = Math.max(counters[i], minValue);
        }
        
        // return value of every counter after all operations
        return counters;
    }
}
