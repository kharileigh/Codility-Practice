/**
 *
 * @author kharileigh
 * < A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

< For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
has exactly four peaks: elements 1, 3, 5 and 10.

You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.



Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:

two flags, you can set them on peaks 1 and 5;
three flags, you can set them on peaks 1, 5 and 10;
four flags, you can set only three flags, on peaks 1, 5 and 10.
You can therefore set a maximum of three flags in this case.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..400,000];
each element of array A is an integer within the range [0..1,000,000,000].
 */

package com.kharileigh.flags;

import java.util.*;

public class Flags {

    public static void main(String[] args) {
        
        // should return 3
        System.out.println(new Flags().solution(new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }
    
    // PEAK - array element larger than its neighbours
    // 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1]
    // Set Maximum Number of Flags on peaks
    public int solution(int[] A) {
    
        // LIST DATA STRUCTURE - unsure of length 
        List<Integer> peaks = new ArrayList<>();
        
        
        // 1 : Establish location of peaks
        for (int i = 1; i < A.length - 1; i++) {
        
            // if value before it, is less than & value after is less, then i is a peak so add to list
            if (A[i - 1] < A[i]) {
                if (A[i + 1] < A[i]) {
                    peaks.add(i);
                }
            }
        }
        
        // 2 : check is any peaks
        if (peaks.size() <= 1) {
            return peaks.size();
        
        } 
        
        
        // 3 : check maximum number of flags
        int maxNumOfFlags = (int)Math.ceil(Math.sqrt(peaks.get(peaks.size() - 1) - peaks.get(0)));
        
        for (int flags = maxNumOfFlags; flags > 1; flags--) {
        
            // flags to be placed on both start & end index
            int startIndex = 0;
            int endIndex = peaks.size() - 1;
            
            int startFlag = peaks.get(startIndex);
            int endFlag = peaks.get(endIndex);
            
            int flagsPlaced = 2;
            
            // iterate from either end, coming towards center
            while (startIndex < endIndex) {
            
                startIndex++;
                endIndex--;
                
                // terminate loop where index crossover, place a flag at that index
                if (peaks.get(startIndex) >= startFlag + flags) {
                    
                    // check that start flag is not being placed to close to an end flag
                    if (peaks.get(startIndex) <= endFlag - flags) {
                
                        // place flag from start direction going in
                        flagsPlaced++;
                        startFlag = peaks.get(startIndex);
                    }
                }
                
                if (peaks.get(endIndex) >= startFlag + flags) {
                    
                    // check that end flag is not being placed to close to an start flag
                    if (peaks.get(endIndex) <= endFlag - flags) {
                    
                        // place flag from end direction coming in
                        flagsPlaced++;
                        endFlag = peaks.get(endIndex);
                    }
                }
                
                
                // return number of flags placed
                if (flagsPlaced == flags) {
                    return flags;
                }
            }
            
        }
        
        return 0;
    }
}
