package leetcode_study;

/**
 * Given a string s, you are allowed to convert it to a palindrome 
 * by adding characters in front of it. 
 * Find and return the shortest palindrome you can find 
 * by performing this transformation.
 * 
 * e.g.
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * 
 * Input: "abcd"
 * Output: "dcbabcd"
 * 
 * Input: "aaaa"
 * Output: "aaaa"
 * 
 * [Approach] KMP
 * 1. when we add chars in front of it, 
 * we can see patterns using (given string + reversed string).
 * 
 * 2. However, in "aaaa" case, "aaaa|aaaa" -> [0,1,2,3,4,5,6,7]
 * 
 *   => By using delimeter between 2 strings, we can solve this issue.
 *      (given string + "#" + reversed string) 
 *      
 *      "aaaa#aaaa" -> [0,1,2,3,0,1,2,3,4]
 *      "abcd#dcba" -> [0,0,.....,1] we need 4-1 = 3 letters(dcb)
 *   
 * [Solution]
 * 1. build lps array using new string (given string + "#" + reversed string) 
 * 2. the new string = rev str's substring(0, [len - lps last elem]) + original str.
 * 
 * @author Sunny Park
 *
 */
public class LC214_ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String newStr = s + "#" + rev;
        int[] lps = buildLps(newStr);
        return rev.substring(0, rev.length() - lps[newStr.length() - 1]) + s;
    }
    
    private static int[] buildLps(String s) {
        int[] lps = new int[s.length()];
        int i = 0;
        
        for (int j = 1; j < s.length(); ) {
            // 3 cases: matched OR not matched(i!=0 or not) 
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    j++;
                }
            }
        }
        return lps;
    }
    
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aaaa"));
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
    }

}
