/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
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
                if (set.contains(word)) {
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
