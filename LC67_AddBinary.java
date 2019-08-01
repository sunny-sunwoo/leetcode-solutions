package leetcode_study;

/**
 * LC67 Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * [Approach] while carry or a or b char is remaining!!! 
 * 1. 2 pointers at the both ends of the char.
 * 2. init SB result and int carry.
 * 3. while 2 pointers or carry is remaining
 *    -> sum = (aNum + bNum + carry) % 2 => append to the result
 *    -> carry = (aNum + bNum + carry) / 2
 * 4. check if carryis remainging   
 * 5. reverse result
 *     
 * @author Sunny Park
 *
 */
public class LC67_AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, 
            j = b.length() - 1;
        int carry = 0;
        
        while (i > 0 || j > 0 || carry > 0) {
            int aNum = i < 0 ? 0 : a.charAt(i--) - '0';
            int bNum = j < 0 ? 0 : b.charAt(j--) - '0';
            
            int sum = (aNum + bNum + carry) % 2;
            carry = (aNum + bNum + carry) / 2;
            result.append(sum);
        }
        
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
    
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
