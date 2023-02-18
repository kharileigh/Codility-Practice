/**
 *
 * @author kharileigh
 *
 * < Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

package com.kharileigh.missinginteger;

import java.util.*;

public class MissingInteger {

    public static void main(String[] args) {
        
        MissingInteger missingInt = new MissingInteger();
        
        // should return 5
        System.out.println(missingInt.solution(new int[] {1, 3, 6, 4, 1 , 2}));
    }
    
    
    public int solution(int[] A) {
        
        // to store values in Array A, using HashSet to maximise efficiency to stop looping through on each remove
        HashSet<Integer> numsInArray = new HashSet<Integer>();
        
        // range must start at 1, end at the next value following last value
        for (int i = 1; i <= A.length + 1; i++) {
            
            numsInArray.add(i);
        }
        
        // remove value if already in hash set 
        for (int arrayItem : A) {
            
            numsInArray.remove(Integer.valueOf(arrayItem));
        }
        
        // return first number in hashSet because it is in order
        return numsInArray.iterator().next();
    }
}
