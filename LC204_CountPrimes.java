package leetcode_study;
/**
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * e.g. 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * [intuition] sieve of Eratosthenes (에라토스테네스의 체) 
 * 2k - 4, 6, 8, 10, 12, ..
 * 3k - 6(already checked) // 9(starting point), 12, ...
 * 4k - already checked.
 * 5k - 10, 15, 20(already checked) // 25(starting point), 30, ..
 * => starting point for each factor N = N^2
 * 
 * [approach] using boolean array to check all Nk
 * 1. create n size boolean array
 * 2. factor out all multiples (range: i = 2; i * i <= n) -> mark true for all multiples
 * 3. count false elems
 * @author Sunny Park
 *
 */
public class LC204_CountPrimes {
    public static int countPrimes(int n) {
        
    }
}
