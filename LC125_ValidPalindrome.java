package leetcode_study;

/**
 * Q. Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.
 * 
 * e.g.
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * @author Sunny Park
 *
 */
public class LC125_ValidPalindrome {
    public static boolean isValidPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }
            
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(input.charAt(left++)) 
                    != Character.toLowerCase(input.charAt(right--))) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));
    }
}
