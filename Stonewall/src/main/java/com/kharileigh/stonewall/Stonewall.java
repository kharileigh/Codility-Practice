/**
 *
 * @author kharileigh
 * < You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

class Solution { public int solution(int[] H); }

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.



Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
 */

package com.kharileigh.stonewall;

import java.util.*;

public class Stonewall {

    public static void main(String[] args) {
        
        // should return 7
        System.out.println(new Stonewall().solution(new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }
    
    
    // H[I] is the height of the wall from I to I+1 meters to the right of its left
    // H[0] is the height of the wall's left end 
    // H[N−1] is the height of the wall's right end.
    public int solution(int[] H) {
    
        // STACK DAT STRUCTURE - to check when a new block is needed
        Stack<Integer> stack = new Stack<>();
        int numOfBlocks = 0;
        
        // iterate through each heights in given array
        for (int i = 0; i < H.length; i++) {
        
            // 1 : check if stack is not empty & check if current item in stack is greater than item in array - remove it
            while (stack.isEmpty() == false && stack.peek() > H[i]) {
                stack.pop();   
            } 
            
            // 2 : check is stack is empty, if add a block & increase counter
            if (stack.isEmpty()) {
                numOfBlocks++;
                stack.push(H[i]);
                
            // 3 : check height - if the same do nothing, if lower height in stack, push new block
            } else if (stack.peek() == H[i]) {
            
            } else if (stack.peek() < H[i]) {
                numOfBlocks++;
                stack.push(H[i]);
            }
        }
        
        // return number of blocks needed to build wall
        return numOfBlocks;
    }
}
