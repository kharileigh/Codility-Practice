/**
 *
 * @author kharileigh
 * < An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

(1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..1,000,000,000].
 */

package com.kharileigh.minperimeterrectangle;


public class MinPerimeterRectangle {

    public static void main(String[] args) {
        
        // should return 22
        System.out.println(new MinPerimeterRectangle().solution(30));
    }
    
    // Length of Rectangle : A * B
    // Perimeter of Rectangle : 2 * (A + B)
    public int solution(int N) {
        
        
        // GLOBAL VARIABLES
        int squareRootN = (int)Math.sqrt(N);
        int perimeter = (1 * 2) + (N * 2);
        
        
        // find number closest to square root of N, use to find perimeter of rectangle
        for (int i = squareRootN; i > 0; i--) {
            
            // if N is divisble by current number, use to calculate perimeter
            if (N % i == 0) {
                
                int A = i;
                int B = N / i;
                
                perimeter = (A * 2) + (B * 2);
                break;
            }
        }
        
    
        return perimeter;
    }
}
