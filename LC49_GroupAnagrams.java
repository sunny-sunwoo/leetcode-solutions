package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *  
 *  LC#49_ Group Anagrams.
 *  
 *  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

 * [Approach]
 * 1. Linear scan.
 * 2. if new combination -> initialize & add new list to the result.
 * 3. else -> add curr word to the specific group.
 * 
 * => anagram check
 * 1. using List<int[]> 
 * 2. if same? rt group number.
 * 3. if not? rt -1.
 *
 * @author Sunny Park
 *
 */
public class LC49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] input) {
        List<List<String>> result = new ArrayList<>();
        List<int[]> dict = new ArrayList<>();
        for (String word : input) {
            int curr = findGroup(dict, word);
            if (curr < 0) {
                result.add(new ArrayList<>());
                curr = result.size() - 1;
            }
            result.get(curr).add(word);
        }
        return result;
    }
    private static int findGroup(List<int[]> dict, String word) {
        int[] curr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            curr[word.charAt(i) - 'a']++;
        }
        int group = 0;
        for (int[] comb : dict) {
            if (matchAnagram(curr, comb)) {
                return group;
            }
            group++;
        }
        dict.add(curr);
        return -1;
    }
    
    private static boolean matchAnagram(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * groupAnagram_map: Better solution!! 
     * 1. Map<String,List>
     * 2. key <=> sorted charArr -> reform the string
     *    e.g. bac -> abc, cba -> abc 
     *    
     * [Note]
     * check if the order matters. 
     * if so, use LHM to keep the order!
     * 
     * [Time/Space]
     * Time: O(NKlogK), where N is the length of strs, 
     * and K is the maximum length of a string in strs. 
     * The outer loop has complexity O(N) as we iterate through each string.
     * Then, we sort each string in O(KlogK) time.
     * 
     * Space: O(NK)
     * @param input
     * @return
     */
    public static List<List<String>> groupAnagram_map(String[] input) {
//        Map<String, List<String>> cache = new LinkedHashMap<>(); // will keep the relative order.
        Map<String, List<String>> cache = new HashMap<>();
        for (String word : input) {
            char[] curr = word.toCharArray();
            Arrays.sort(curr);
            String key = String.valueOf(curr);
            List<String> currList = cache.getOrDefault(key, new ArrayList<String>());
            currList.add(word);
            cache.put(key, currList);
        }
        return new ArrayList<>(cache.values());
    }
    
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(arr));
        System.out.println(groupAnagram_map(arr));
    }
}
