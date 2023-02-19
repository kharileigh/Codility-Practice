/**
 *
 * @author kharileigh
 * < An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */

package com.kharileigh.dominator;

import java.util.*;

public class Dominator {

    public static void main(String[] args) {
        
//        // should return either 0, 2, 4, 6, 7
//        System.out.println(new Dominator().solution(new int[] {3, 4, 3, 2, 3, -1, 3, 3}));
        
        // should return 3
        System.out.println(new Dominator().solution(new int[] {3, 4, 3, 2, 3, -1, 3, 3}));
    }
    
    
    // dominator is an element that occurs more than half of the elements in array
    public int solution(int[] A) {
    
        // HASHMAP DATA STRUCTURE - for counting elements
        Map<Integer, Integer> map = new HashMap<>();
        
        // 1 : map element to key, number of times it appears as its value in map
        for (int i = 0; i < A.length; i++) {
        
            // check if map contains current element first - if it doesn't add it with a value of 1
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            
            // if element already in map, get its value - save value as counter then increase it by each increment 
            } else {
                
                int counter = map.get(A[i]);
                map.put(A[i], counter + 1);
            }
        }
        
        
        // 2 : check maximum number & its respective maximum number it appears
        int dominator = 0;
        int maxNumOfCounts = 0;
        
        // iterate through every key in map
        for (int key : map.keySet()) {
            
            // get value from each key
            int numOfCounts = map.get(key);
            
            // check if value is greate than maxNumOfCounts, if yes update max count & dominator
            if (numOfCounts > maxNumOfCounts) {
            
                maxNumOfCounts = numOfCounts;
                dominator = key;
            }
        }
        
        // 3 : check if dominator is in map or not
        if (maxNumOfCounts > (A.length) / 2) {
            // is dominator if appears more than half times in map
            
        } else {
            return -1; 
        }
        
        
        // 4: return any index of the dominator
        for (int i = 0; i < A.length; i++) {
            
            if (A[i] == dominator) {
                
                return i;
            }
        }
        
        return -1;
    }
}


