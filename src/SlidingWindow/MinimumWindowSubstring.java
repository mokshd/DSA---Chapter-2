package SlidingWindow;

public class MinimumWindowSubstring {

/*
==========================================================
Problem: Minimum Window Substring (LeetCode 76)
Pattern: Variable Sliding Window + Frequency Array
==========================================================

INTUITION
---------
Find the smallest substring of s containing all
characters of t, including their required frequencies.

Example:
s = "ADOBECODEBANC"
t = "ABC"

Output: "BANC"

Key idea:
1. Expand right until the window contains all characters.
2. Shrink left while the window remains valid.
3. Track the smallest valid window.


----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
Generate every possible substring and check whether
it contains all required character frequencies.

Pseudo:
// required = frequency array of t
// minLength = infinity
//
// for i = 0 to n-1:
//     windowFreq = new frequency array
//
//     for j = i to n-1:
//         windowFreq[s[j]]++
//
//         if window contains all required frequencies:
//             update minimum window
//
// return answer

TC: O(n^2 * m) = O(n^3) worst case
SC: O(1) for a fixed-size character array

Your Solution 1 is correct.

Why O(n^3)?
- O(n^2) possible substrings.
- Each validity check takes O(m), where m = t.length().


----------------------------------------------------------
APPROACH 2 - Sliding Window + Frequency Validation
----------------------------------------------------------

Idea:
Maintain character frequencies of the current window.

1. Expand right.
2. Check whether the window contains t.
3. While valid:
   - Update minimum answer.
   - Remove the left character.
   - Move left forward.

Pseudo:
// required = frequency array of t
// window = frequency array
// left = 0
//
// for right = 0 to n-1:
//     window[s[right]]++
//
//     while window contains all required frequencies:
//         update minimum answer
//         window[s[left]]--
//         left++
//
// return answer

TC: O(128 * n) = O(n)
SC: O(128) = O(1)

Your Solution 2 follows this approach.

Important:
Your valid() scans all 126 positions each time.
This is correct but performs unnecessary comparisons.


----------------------------------------------------------
APPROACH 3 - Optimal: Sliding Window + Formed Counter
----------------------------------------------------------

Idea:
Instead of repeatedly scanning the frequency array,
maintain how many DISTINCT required characters have
reached their required frequency.

required = number of distinct characters in t
formed = number of distinct characters currently
         satisfying their required frequency.

Window is valid when:

formed == required

Expand:
- Add incoming character.
- If its frequency becomes exactly the required
  frequency, increment formed.

Shrink:
- If outgoing character currently has exactly its
  required frequency, decrement formed.
- Remove outgoing character.

Pseudo:
// need = frequency array of t
// window = frequency array
//
// required = number of distinct characters in t
// formed = 0
// left = 0
//
// for right = 0 to n-1:
//     ch = s[right]
//     window[ch]++
//
//     if need[ch] > 0 AND window[ch] == need[ch]:
//         formed++
//
//     while formed == required:
//         update minimum window
//
//         leftChar = s[left]
//
//         if need[leftChar] > 0 AND
//            window[leftChar] == need[leftChar]:
//             formed--
//
//         window[leftChar]--
//         left++
//
// return answer

TC: O(n + m)
SC: O(128) = O(1)


----------------------------------------------------------
BEST INTERVIEW IMPLEMENTATION
----------------------------------------------------------

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length() || t.isEmpty()) {
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];

        int required = 0;
        int formed = 0;

        for (char ch : t.toCharArray()) {
            if (need[ch] == 0) {
                required++;
            }
            need[ch]++;
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            window[ch]++;

            if (need[ch] > 0 && window[ch] == need[ch]) {
                formed++;
            }

            while (formed == required) {

                int length = right - left + 1;

                if (length < minLength) {
                    minLength = length;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (need[leftChar] > 0 &&
                    window[leftChar] == need[leftChar]) {
                    formed--;
                }

                window[leftChar]--;
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}


----------------------------------------------------------
UNDERSTANDING FORMED AND REQUIRED
----------------------------------------------------------

Example:
t = "AABC"

Required frequencies:
A = 2
B = 1
C = 1

required = 3 (distinct characters)

Suppose current window contains:
A = 2, B = 1, C = 1

formed = 3

Therefore:
formed == required
Window is valid.

Suppose current window contains:
A = 1, B = 1, C = 1

formed = 2

Window is invalid because A requires 2 occurrences.

IMPORTANT:
formed counts DISTINCT satisfied characters,
NOT the total number of matched characters.

When adding:
if window[ch] == need[ch]:
    formed++

When removing:
if window[ch] == need[ch]:
    formed--

Check the removal condition BEFORE decrementing
the window frequency.


----------------------------------------------------------
WHY SHRINK LEFT?
----------------------------------------------------------

Once the window is valid, try removing characters
from the left.

If it remains valid:
    It may be a smaller answer.

If it becomes invalid:
    Stop shrinking and expand right again.

This guarantees we consider the smallest valid window
ending at each right boundary.


----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• Why use formed instead of valid()?
  Avoids scanning all 128 frequency positions repeatedly.

• Why count distinct characters in required?
  We need to know how many character requirements
  must be satisfied.

• Why check window[ch] == need[ch]?
  That is the exact point at which a character requirement
  becomes satisfied.

• Why check before decrementing?
  Removing a character that is exactly at its required
  frequency makes the window invalid.

• Why is this a variable-size sliding window?
  Expand until valid, then shrink to minimize.

• What if t contains duplicates?
  Frequency counting handles duplicates automatically.

• What if no valid window exists?
  Return an empty string.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• s = "", t = "A" -> ""
• s shorter than t -> ""
• s = "A", t = "A" -> "A"
• s = "ADOBECODEBANC", t = "ABC" -> "BANC"
• s = "AA", t = "AA" -> "AA"
• s = "AB", t = "AABC" -> ""
• s = "AAABBC", t = "AABC" -> "AABBC"


----------------------------------------------------------
REMEMBER
----------------------------------------------------------

• Minimum Window Substring = Variable Sliding Window.
• Need frequency counts, not just character presence.
• Expand right to make the window valid.
• Shrink left to minimize the window.
• required = distinct characters in t.
• formed = distinct characters currently satisfied.
• formed == required means valid window.
• Check frequency BEFORE decrementing on removal.
• Store start + minLength rather than repeatedly creating
  substrings inside the loop.
• Use 128 for standard ASCII input; use a Map or a
  suitable Unicode-aware approach for broader input.


----------------------------------------------------------
COMPLEXITY COMPARISON
----------------------------------------------------------

Brute Force:
TC: O(n² * m)
SC: O(1) fixed alphabet

Sliding Window + valid():
TC: O(128 * n) = O(n)
SC: O(128) = O(1)

Sliding Window + formed:
TC: O(n + m)
SC: O(128) = O(1)

==========================================================
*/

}
