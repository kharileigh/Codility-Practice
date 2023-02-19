/**
 *
 * @author kharileigh
 * < You are given two non-empty arrays A and B consisting of N integers. These arrays represent N planks. More precisely, A[K] is the start and B[K] the end of the K−th plank.

Next, you are given a non-empty array C consisting of M integers. This array represents M nails. More precisely, C[I] is the position where you can hammer in the I−th nail.

We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].

The goal is to find the minimum number of nails that must be used until all the planks are nailed. In other words, you should find a value J such that all planks will be nailed after using only the first J nails. More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].

For example, given arrays A, B such that:

    A[0] = 1    B[0] = 4
    A[1] = 4    B[1] = 5
    A[2] = 5    B[2] = 9
    A[3] = 8    B[3] = 10
four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].

Given array C such that:

    C[0] = 4
    C[1] = 6
    C[2] = 7
    C[3] = 10
    C[4] = 2
if we use the following nails:

0, then planks [1, 4] and [4, 5] will both be nailed.
0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
0, 1, 2, 3, then all the planks will be nailed.
Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed.

Write a function:

class Solution { public int solution(int[] A, int[] B, int[] C); }

that, given two non-empty arrays A and B consisting of N integers and a non-empty array C consisting of M integers, returns the minimum number of nails that, used sequentially, allow all the planks to be nailed.

If it is not possible to nail all the planks, the function should return −1.

For example, given arrays A, B, C such that:

    A[0] = 1    B[0] = 4
    A[1] = 4    B[1] = 5
    A[2] = 5    B[2] = 9
    A[3] = 8    B[3] = 10

    C[0] = 4
    C[1] = 6
    C[2] = 7
    C[3] = 10
    C[4] = 2
the function should return 4, as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..30,000];
each element of arrays A, B and C is an integer within the range [1..2*M];
A[K] ≤ B[K].
 */

package com.kharileigh.nailingplanks;

import java.util.*;

public class NailingPlanks {

    public static void main(String[] args) {
        
        // should return 4
        System.out.println(new NailingPlanks().solution(new int[] {1, 4, 5, 8}, new int[] {4, 5, 9, 10}, new int[] {4, 6, 7, 10, 2}));
    }
    
    
    // 1 : CLASS TO REPRESENT NAIL - to be find using value, not index
    class Nail implements Comparable<Nail> {
        int index;
        int value;
        
        // constructor
        public Nail(int index, int value) {
            super();
            this.index = index;
            this.value = value;
        }
        
        // toString method 
        @Override
        public String toString() {
            return "Nail [index = " + index + ", value = " + value + "]";
        }

        // to help sort Nail by value
        @Override
        public int compareTo(Nail o) {
            return value - o.value;
        }
        
    }
    
    
    // 2. CLASS TO REPRESENT PLANK 
    class Plank implements Comparable<Plank> {
        int start;
        int end;
        
        // constructor
        public Plank(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }
        
        // toString method
        @Override 
        public String toString() {
            return "Plank [start = " + start + ", end = " + end + "]";
        }

        // sort by start position, increasing each time
        @Override
        public int compareTo(Plank o) {
            return start - o.start;
        }
    
    }
    
    
    
    
    // FIND MINIMUM NUMBER OF NAILS - that must be used until all the planks are nailed
    public int solution(int[] A, int[] B, int[] C) {
        
        // 3 : SET TO CHECK NAILS THAT HAVE BEEN SEEN
        Set<Integer> nailsSeen = new HashSet<>();
        
        // 4 : LIST TO HOLD NAILS
        List<Nail> nails = new ArrayList<>();
        
        // C array defines nails - value in nail is the value in C
        for (int i = 0; i < C.length; i++) {
            
            // if empty, add to nails
            if(!nailsSeen.contains(C[i])) {
                nails.add(new Nail(i + 1, C[i]));
                
                // if nails has been seen, ignore it
                nailsSeen.add(C[i]);
            }
        }
        // 4 : SORT NAILS
        Collections.sort(nails);
        
        
        // 5 : PLANK ARRAY - hold all planks
        List<Plank> planks = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            planks.add(new Plank(A[i], B[i]));
        }
        
        
        // 6 : ITERATE THROUGH PLANKS - previous plank ends after the plank looking at, 
        Collections.sort(planks);
        
        for (int i = 0; i < planks.size() - 2; i++) {
            
            // keep removing plank before it until plank before it ends directly before it
            while (i > 0 && planks.get(i).end > planks.get(i + 1).end) {
                planks.remove(i--);
            }
        }
        
        
        // 7 : ITERATE THROUGH PLANKS & USE BINARY SEARCH ON NAILS - find minimum index of a nail
        int maxMin = 0;
        for (Plank plank : planks) {
            int minNailIndex = getMinNailIndex(nails, plank);
            
            // if nail canno hit current plank
            if (minNailIndex == -1) {
                return -1;
            }
            
            maxMin = Math.max(maxMin, minNailIndex);
        }
        
        return maxMin;
    }
    
    
    
    // 8 : METHOD TO DO BINARY SEARCH
    public int getMinNailIndex(List<Nail> nails, Plank plank) {
    
        int start = 0;
        int end = nails.size() - 1;
        int result = - 1;
        
        while (start <= end) {
            
            int centrePosition = (start + end) / 2;
            if (nails.get(centrePosition).value < plank.start) {
                
                start = centrePosition + 1;
  
            } else if (nails.get(centrePosition).value > plank.end) {
            
                end = centrePosition - 1;
            
            // if a number of nails can hit plank 
            } else {
                result = centrePosition;
                end = centrePosition - 1;
            }
        }
        
        // if none can hit plank
        if (result == -1) {
            return -1;
        }
        
        int minIndex = nails.get(result).index;
        for (int i = result + 1; i < nails.size(); i++) {
            if (nails.get(i).value <= plank.end) {
                minIndex = Math.min(minIndex, nails.get(i).index);
                
            } else {
                return minIndex;
            }
        }
        
        return minIndex;
    }
   
}
