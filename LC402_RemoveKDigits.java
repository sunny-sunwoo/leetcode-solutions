package leetcode_study;

public class LC402_RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        int i = 0;
        while (k > 0 && i < sb.length() - 1) {
            System.out.println(k + ", " + i);
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                i--;
                k--;
            }
            i++;
        }
        
        return removeZeroes(sb);
    }
    
    private static String removeZeroes(StringBuilder sb) {
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }
        return sb.length() == idx ? "0" : sb.substring(idx, sb.length());
    }
    
    public static void main(String[] args) {
        String num = "1122";
        System.out.println(removeKdigits(num, 1));
        System.out.println('1' > '2');
    }
}
