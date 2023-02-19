/**
 *
 * @author kharileigh
 * < A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000];
string S is made only of the characters "(" and/or ")".
 */

package com.kharileigh.nesting;

import java.util.*;

public class Nesting {

    public static void main(String[] args) {
        
        // should return 1 
        System.out.println(new Nesting().solution(new String("(()(())())")));
    }
    
    
    public int solution(String S) {
        
        // edge case - check if empty string
        if (S.length() == 0) {
            return 0;
        }
        
        // edge case - check if odd length, properly nested would be an even amount of characters
        if (S.length() % 2 == 1) {
            return 0;
        }
    
        // STACK DATA STRUCTURE - to check if its paired character is in it, keep if it is
        Stack<Character> stack = new Stack<>();
        
        // iterate through characters  if not pop
        for (int i = 0; i < S.length(); i++) {
        
            // push matching character 
            if (S.charAt(i) == '(') {
                stack.push(')');
              
            // pop if no matching character
            } else if (S.charAt(i) == ')') {
            
                // check if stack empty before pop
                if (stack.isEmpty() == true) {
                    return 0;
                } else {
                    char check = stack.pop();
                    if (check != ')') {
                        return 0;
                    }
                }
            }
        }
        
        // return stack, check if empty first
        if (!stack.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }
}
