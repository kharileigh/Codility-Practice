/**
 *
 * @author kharileigh
 * < A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S is made only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */


package com.kharileigh.brackets;

import java.util.*;

public class Brackets {

    public static void main(String[] args) {
        
        // should return 0
        System.out.println(new Brackets().solution(new String("([)()]")));
        
        // should return 0
        System.out.println(new Brackets().solution(new String("{[()()}}")));
        
        
    }
    
    // using STACK 
    public int solution(String S) {
        
        // special case
        if (S.length() == 0) {
            return 1;
        }
        
        Stack<Character> stack = new Stack<>();
        
        // iterate through String, taking character out of the String
        for (int i = 0; i < S.length(); i++) {
        
            // push its pair
            if( S.charAt(i) == '(' ){
                stack.push(')');
                
            } else if (S.charAt(i) == '[') {
                stack.push(']');
                
            } else if (S.charAt(i) == '{') {
                stack.push('}');
                
            // check if stack is empty, then pop
            } else if (S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == ')') {
                
                if(stack.isEmpty() == true) {
                    return 0;
                    
                } else {
                    char temp = stack.pop();
                    if (temp != S.charAt(i)) {
                        return 0;
                    }
                }
          
            }
        }
        
        // checking if stack is empty or not
        if (!stack.isEmpty()) {
            return 0;
            
        } else {
            return 1;
        }
    }
}
