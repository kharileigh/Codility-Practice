/**
 *
 * @author kharileigh
 * <Given a positive integer N, prints consecutive numbers from 1 to N, each on a separate line
 * Any number divisible by 2, 3 or 5 should be replaced by the word Codility, Test or Coders respectively
 * 
 * If a number is divisible by more than one of the numbers : 2, 3, 5 - should be replaced by a concatenation of the respective words Codility, Test and Coders in this given order
 * 
 * Function shouldn't return any value
 * N is an integer within 1.. 1000
 */

package com.kharileigh.examquestion2;


public class ExamQuestion2 {

    public static void main(String[] args) {
        
        
        // should return 
        solution(5);
    }
    
    
    static void solution(int N) {
    
        // 1 : GLOBAL VARIABLES - start & end point of range
        int start = 1;
        int end = N;
        
        
        // 2 : ITERATE FROM 1 TO N 
        while (start < end) {
        
            // for every consecutive number, check if it is divisible by 2, 3, 5
            for (int num = start + 2; num <= end; num++) {
                
                // variables 
                boolean twoD = num / 2 == 0;
                boolean threeD = num / 3 == 0;
                boolean fiveD = num / 5 == 0;
                
                // divisible by 2
                if (twoD) {
                    System.out.println("\nCodility");
                }
                
                // divisible by 3
                if (threeD) {
                    System.out.println("\nTest");
                }
                
                // divisible by 5
                if (fiveD) {
                    System.out.println("\nCoders");
                }
                
                // divisible by all three - print concatenation
                
                
                if (twoD || threeD || fiveD) {
                    System.out.println("" + twoD + threeD + fiveD + "");
                }
            }
        }
    }
    
}
