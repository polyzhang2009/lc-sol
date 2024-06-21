/*
 * @lc app=leetcode id=291 lang=java
 *
 * [291] Word Pattern II
 */

// @lc code=start
class Solution {
    // 291 和290的差别在于， 291 是需要把S 切分成不同的word，空间复杂度为O(m), 290 是需要把S 切分成不同的word，空间复杂度为O(1)
    
    public boolean wordPatternMatch(String pattern, String s) {
        
      String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        // HashMap for mapping from character to word
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (set.contains(word)) {  // for case "abba", "dog dog dog dog"
                    return false;
                }
                map.put(c, word);
                set.add(word);
            }
        }
        return true;
    }
}
// @lc code=end

