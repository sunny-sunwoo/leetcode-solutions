package leetcode_study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC828_UniqueLetterString {
    
    public static int uniqueLetterString(String S) {
        Map<Character, List<Integer>> cache = buildMap(S);
        long result = 0;
        for (List<Integer> list : cache.values()) {
            for (int i = 0; i < list.size(); i++) {
                long prev = i > 0 ? list.get(i - 1) : -1;
                long next = i < list.size() - 1 ? list.get(i + 1) : S.length();
                result += (list.get(i) - prev) * (next - list.get(i));
            }
        }
        return (int) result % 1_000_000_007;
    }
    
    private static Map<Character, List<Integer>> buildMap(String s) {
        Map<Character, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> currList = cache.getOrDefault(s.charAt(i), new ArrayList<>());
            currList.add(i);
            cache.put(s.charAt(i), currList);
        }
        return cache;
    }
    
    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
    }
}
