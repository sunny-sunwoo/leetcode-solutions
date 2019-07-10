package leetcode_study;

/**
 * Q. Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * [Approach]
 * 1. get 1's digit. using %
 * 2. update the num.  using /
 * 
 * [Note]
 * 1. negative opr
 *    -123 / 10 = -12
 *    -123 % 10 = -3
 *    
 * 2. reverse can integer overflow.
 *    - use long value. 
 *    - cast when returning.
 *    - how to deal with that?  -> return 0 in this case.
 *    
 * @author Sunny Park
 *
 */

public class LC07_ReverseInteger {
    public static int reverse(int x) {
        long result = 0;
        int num = x;
        while (num != 0) {
            result = result * 10 + num % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            num = num / 10;
        }
        return (int) result;
    }
    
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
