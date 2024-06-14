/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {

    // Using two pointers approach
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort the array to easily handle duplicates and for the two-pointer approach

        List<List<Integer>>  res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // skip duplicate
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum =  nums[left] + nums[right];
                
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplcates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicate for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
            
                } else if (sum < target) {
                    left++; // Increase the left pointer to get a larger sum
                } else {
                    right--; // Decrease the right pointer to get a smaller sum
                }
            }
        }
        return res;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums); // Sort the array to easily handle duplicates and for the two-pointer approach

        List<List<Integer>>  res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // skip duplicate
            
            int target = -nums[i];
            List<List<Integer>> pairs = twoSum(nums, target, i);

            for (List<Integer> pair : pairs) {
                pair.add(nums[i]);
                res.add(pair);
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int idx) {
        // nums: [1,2,3,4] , target: 5
        // key: 1  , 4
        // val: 0, 3
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = idx + 1; i < nums.length; i++) {  // Start from idx + 1 to avoid using the same element
            int key = target - nums[i];
            if (map.containsKey(key)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[map.get(key)]);
                pair.add(nums[i]);
                res.add(pair);

                // Avoid duplicate in pairs
                while ( i+ 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++; 
                }
            } else {
                map.put(nums[i], i);
            }
        }
    
        return res;
    }
}
// @lc code=end

