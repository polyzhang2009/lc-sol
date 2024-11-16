/*
 * @lc app=leetcode id=2384 lang=java
 *
 * [2384] Largest Palindromic Number
 */

// @lc code=start
class Solution {
    public String largestPalindromic(String num) {
     
        // Step 1: Count digit frequencies
        int[] freq = new int[10];
        for (char c : num.toCharArray()) {
            freq[c - '0']++;
        }

        // Step 2: Build the left half and find the middle digit
        StringBuilder leftHalf = new StringBuilder();
        String middle = "";

        for (int digit = 9; digit >= 0; digit--) {
            int count = freq[digit];

            // Add pairs of the current digit to the left half
            for (int i = 0; i < count / 2; i++) {
                if (leftHalf.length() > 0 || digit != 0) { // Skip leading zeros
                    leftHalf.append((char) (digit + '0'));
                }
            }

            // If there’s an odd count and no middle digit yet, select this digit
            if (count % 2 == 1 && middle.isEmpty()) {
                middle = String.valueOf(digit);
            }
        }

        // Special case: All zeros
        // if (leftHalf.length() == 0 && middle.isEmpty()) {
        //     return "0";
        // }

        // Step 3: Construct and return the final palindrome
        String rightHalf = leftHalf.reverse().toString();
        return leftHalf.reverse().toString() + middle + rightHalf;
    }

}
// @lc code=end

public static void main(String [] args) {
    // you can write to stdout for debugging purposes, e.g.

    String num = "444947137";
    System.out.println("input: " + num + "\n output: " + largestPalindormNum(num));

    String num2 = "00009";
    System.out.println("input: " + num2 + "\n output: " + largestPalindormNum(num2));

    String num3 = "9000900";
    System.out.println("input: " + num3 + "\n output: " + largestPalindormNum(num3));

    String num4 = "54321012345";
    System.out.println("input: " + num4 + "\n output: " + largestPalindormNum(num4));

    String num5 = "0000000000";
    System.out.println("input: " + num5 + "\n output: " + largestPalindormNum(num5));

}

/*
num = "444947137"

freq [] 
    4: 4
    9: 1
    7: 2
    1: 1
    [9, 8, 7... 0]
    left half :  7,44,  skip if  leading zero 000 
    middle: 9
    right half : 44, 7

    final: 7 44 9 44 7

*/
// Time complexity: O(n), Space complexity: O(1)
public static String largestPalindormNum(String num) {
    int[] freq = new int[10];

    // Count the digit frequency , time complexity O(n)
    for (char c : num.toCharArray()) {
        freq[c - '0']++;
    }

    // build the left half 
    StringBuilder leftHalf = new StringBuilder();
    String middle = "";

    // iterate through 0 - 9,  time complexity O(10)
    for (int digit = 9; digit >= 0 ; digit--) {
        int count = freq[digit];
        for (int i = 0; i < count / 2; i++) {
            // construct the left part, skip leading zeros
            if (leftHalf.length() > 0 || digit != 0) {
                leftHalf.append((char)(digit + '0'));
            }
        }

        // check if count is odd, update middle with select digit 
        if (count % 2 == 1 & middle.isEmpty()) {
            middle = String.valueOf(digit);  // 9 as middle
        }
    }

    // handle special case: all 0s , "00000000" -> "0"
    if (leftHalf.length() == 0 && middle.isEmpty()) {
        return "0";
    }

    // build the right half
    String rightHalf = leftHalf.reverse().toString();
    return leftHalf.reverse().toString() + middle + rightHalf;
}
