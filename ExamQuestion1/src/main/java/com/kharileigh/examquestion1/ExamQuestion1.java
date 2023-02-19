/**
 *
 * @author kharileigh
 * <a word machine is a system that performs a sequence of simple operations on a stack of integers 
 * Initially the stack is empty
 * sequence of operation is given as a string
 * operations are separated by single spaces
 *  
 * GIVEN - STRING CONTAINING SEQUENCE OF OPERATIONS
 * RETURNS - RESULT MACHINE WOULD RETURN AFTER PROCESSING OPERATIONS 
 * RETURN : -1 IF ERROR
 * 
 * LENGTH OF STRING - 0.. 2000
 * S IS A VALID SEQUENCE OF WORD MACHINE OPERATIONS
 */

package com.kharileigh.examquestion1;

import java.util.*;

public class ExamQuestion1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
    
    public int solution(String S) {
        
        // 1 : EDGE CASE 
        if (S.length() == 0) {
            return 1;
        }
        
        
        // 2 : ITERATE THROUGH STRING, TAKING EACH STRING OUT & ADDING TO STACK
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < S.length(); i++) {
        
            // integer operation - push onto stack
            if (S.equals(i > 0 || i < 2000)) {
                stack.push(S);
                
            // check if stack is empty before pop operation
            if (stack.isEmpty() == true) {
                return 0;
            }
            
            // pop topmost number from stack
            } else if (i == Integer.MAX_VALUE){
                stack.pop();
            
            // duplicate pushed to top
            } else if (stack.contains(i)) {
                stack.push(S);
            
            // pops topmost elements, sum, push back 
            } else {
                
                String last = stack.lastElement();
                String secondLast = stack.get(i - 2);
                
                int 
                
            }
            
            // pops topmost elements, subtracts pushes back 
        
        
    
        }
    
        // 3 : RETURN FINAL OPERATIONS 
        if (!stack.isEmpty()) {
            return 0;
            
        } else {
            return 1;
        }
}
