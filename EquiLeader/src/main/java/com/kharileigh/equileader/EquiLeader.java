/**
 *
 * @author kharileigh
 * < A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */

package com.kharileigh.equileader;

import java.util.*;

public class EquiLeader {

    public static void main(String[] args) {
        
        // should return 2
        System.out.println(new EquiLeader().solution(new int[] {4, 3, 4, 4, 4, 2}));
    }
    
    
    // LEADER - value that appears more than half times in array ( only leader of whole array can have an equi leader
    public int solution(int[] A) {
        
        // HASHMAP DATA STRUCTURE - for counting elements to find leader of array
        Map<Integer, Integer> map = new HashMap<>();
        
        // 1 : map element to key, number of times it appears as its value in map
        for (int i = 0; i < A.length; i++) {
        
            // check if map contains current element first - if it doesn't add it with a value of 1
            if( !map.containsKey(A[i])) {
                map.put(A[i], 1);
                
            // if element already in map, get its value - increment value by 1
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        
        // 2 : check maximum number & its respective maximum number it appears
        int maxNum = 0;
        int maxNumOfCounts = 0;
        
        // iterate through every key in map
        for (int key : map.keySet()) {
            
            // get value from each key
            int numOfCounts = map.get(key);
            
            // check if value is greate than maxNumOfCounts, if yes update max count & leader
            if (numOfCounts > maxNumOfCounts) {
                maxNumOfCounts = numOfCounts;
                maxNum = key;
            }
       
        }
        
        // 3 : check for leader - must appear more than half times in array
        int leaderValue = 0;
        int leaderCount = 0;
        
        // if max count appears more than half, it is the leader
        if (maxNumOfCounts > (0.5) * (A.length)) {
            
            leaderValue = maxNum;
            leaderCount = maxNumOfCounts;
        
        // if no leader
        } else {
            return 0;
        }
        
        
        // 4 : check for equi leaders - both sides of array have same leader
        int equiLeaders = 0;
        int leftCount = 0; 
        
        for (int i = 0; i < A.length; i++) {
            
            // check array for leader on left
            if (A[i] == leaderValue) {
                leftCount++;
            }
            
            // if leader on left, check if leader on right also
            if (leftCount > (0.5) * (i + 1)) {
            
                int rightCount = leaderCount - leftCount;
                if (rightCount > (0.5) * (A.length - i - 1)) {
                
                    equiLeaders++;
                }
            }
        }
        
        // return number of equi leaders
        return equiLeaders;
    }
}
