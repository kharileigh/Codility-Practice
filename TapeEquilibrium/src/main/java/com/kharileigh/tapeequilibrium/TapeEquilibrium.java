/**
 *
 * @author kharileigh
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].

 */

package com.kharileigh.tapeequilibrium;


public class TapeEquilibrium {

    
    public static void main(String[] args) {
        
        // return 1
        System.out.println(new TapeEquilibrium().solution(new int[] {3, 1, 2, 4, 3}));
    }
    
    
    public int solution(int[] A) {
        
        // RETURN VALUE - difference between both sides
        int minDifference = Integer.MAX_VALUE;
        
        
        // first get total value of array, but not going to the end
        // these will be right hand side split, looping through will get the left hand side
        int numbersOnTheRight = 0;
        for (int P = 0; P < A.length; P++) {
            
            numbersOnTheRight += A[P];
        }
      
        
        
        // iterate through again and substract numbers on the right, add them to numbers on the left
        int numbersOnTheLeft = 0;
        for (int P = 0; P < A.length - 1; P++) {
        
            numbersOnTheRight -= A[P];
            numbersOnTheLeft += A[P];
            
            // P has to be bigger than 0 and lower than N
            if (P > 0) {
                if(Math.abs(numbersOnTheLeft - numbersOnTheRight) < minDifference) {

                    minDifference = Math.abs(numbersOnTheLeft - numbersOnTheRight);
                }
            }
        }
    
        return minDifference;
    }
}
