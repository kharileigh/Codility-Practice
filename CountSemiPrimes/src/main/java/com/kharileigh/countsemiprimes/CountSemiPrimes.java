/**
 *
 * @author kharileigh
 * < A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
The number of semiprimes within each of these ranges is as follows:

(1, 26) is 10,
(4, 10) is 4,
(16, 20) is 0.
Write a function:

class Solution { public int[] solution(int N, int[] P, int[] Q); }

that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..50,000];
M is an integer within the range [1..30,000];
each element of arrays P and Q is an integer within the range [1..N];
P[i] ≤ Q[i].
 */


package com.kharileigh.countsemiprimes;

import java.util.*;


public class CountSemiPrimes {

    public static void main(String[] args) {
       
        
        int[] semiPrimes = new CountSemiPrimes().solution(26, new int[] {1, 4, 16}, new int[] {10, 4, 0});
        
        // should return [10, 4, 0]
        for (int value : semiPrimes) {
            System.out.println(value);
        }
        
    }
    
    
    
    // PRIME : a positive integer X that has exactly two distinct divisors: 1 and X.
    // SEMIPRIME : a natural number that is the product of two (not necessarily distinct) prime numbers
    // Find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N
    // Using Sieve of Eratosthenes - used for finding all prime numbers up to any given limit.
    public int[] solution(int N, int[] P, int[] Q) {
    
        
        // 1 : FIND NON PRIME NUMBERS
        boolean[] notPrimeNumber = new boolean[N + 1];
        for (int i = 2; i <= N / 2; i++) {
            for (int j = i * 2; j <= N; j += i) {
                
                notPrimeNumber[j] = true;
            }
        }
        
        
        // 2 : STORE ALL PRIME NUMBERS IN LIST
        List<Integer> primeNumber = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if(!notPrimeNumber[i]) {
                primeNumber.add(i);
            }
        }
        
        
        // 3 : STORE SEMI PRIMES IN ARRAY
        int[] semiPrimeNumber = new int[N + 1];
        for (int i = 0; i < primeNumber.size() - 1; i++) {
            for (int j = i; j < primeNumber.size() - 1; j++) {
                
                
                int primeI = primeNumber.get(i);
                int primeJ = primeNumber.get(j);
                
                // if out of range, end loop
                if (primeI * primeJ >= semiPrimeNumber.length) {
                    break;
                }
                semiPrimeNumber[primeI * primeJ] = 1;
            }
        }
        
        
        // 4 : ITERATE THROUGH SEMI PRIMES
        int k = 0;
        for (int a = 0; a < semiPrimeNumber.length; a++) {
            k += semiPrimeNumber[a];
            semiPrimeNumber[a] = k;
        }
        
        
        // 5 : RETURN ARRAY OF SEMIPRIMES 
        int[] result = new int[P.length];
        
        for (int b = 0; b < P.length; b++) {
            result[b] = semiPrimeNumber[Q[b]] - semiPrimeNumber[P[b] - 1];
        }
        
        return result;
    }
}
