/**
 *
 * @author kharileigh
 * < A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
 */

package com.kharileigh.countfactors;


public class CountFactors {

    public static void main(String[] args) {
        
        // should return 8
        System.out.println(new CountFactors().solution(24));
    }
    
    
    // Factor :  N = D * M 
    // D is a factor of N because multipled by M, equals N
    public int solution(int N) {
        
        
        // GLOBAL VARIABLES
        int squareRootN = (int) Math.sqrt(N);
        int numOfFactors = 0;
        
        
        // 1 : check if element is a factor or not
        for (int i = 1; i <= squareRootN; i++) {
            
            // if N is divisible by current value, increase number of factors
            if (N % i == 0) {
                numOfFactors++;
            }
        }
        
        
        // 2 : add given number's pair
        numOfFactors = numOfFactors * 2;
        
        
        // 3 : check if square root of given number equals N
        if (squareRootN * squareRootN == N) {
            
            // minus one avoids counting double
            numOfFactors = numOfFactors - 1;
        }
    
        return numOfFactors;
    }
}
