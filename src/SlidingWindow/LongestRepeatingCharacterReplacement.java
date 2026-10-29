package SlidingWindow;

public class LongestRepeatingCharacterReplacement {

/*
==========================================================
Problem: Longest Repeating Character Replacement (LC 424)
Pattern: Sliding Window + Frequency Array
==========================================================

INTUITION
---------
Find the longest substring that can be made of one
repeated character using at most k replacements.

For a window:
replacementsNeeded = windowLength - maxFrequency

Why?
Keep the most frequent character and replace all others.

Valid window:
windowLength - maxFrequency <= k


----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
Try every starting index and expand the window.
Track character frequencies and the maximum frequency.

Pseudo:
// res = 0
// for left = 0 to n-1:
//     freq[26] = 0
//     maxFreq = 0
//
//     for right = left to n-1:
//         freq[s[right] - 'A']++
//         maxFreq = max(maxFreq, freq[s[right] - 'A'])
//
//         windowLength = right-left+1
//         if windowLength-maxFreq <= k:
//             res = max(res, windowLength)
//
// return res

TC: O(n^2)
SC: O(1) — fixed 26-element array

Your Solution 1 is correct.


----------------------------------------------------------
APPROACH 2 - Optimal: Sliding Window
----------------------------------------------------------

Idea:
Expand right and update character frequencies.

If windowLength - maxFreq > k:
    Move left forward by one.

Track the maximum valid window length.

Pseudo:
// left = 0
// maxFreq = 0
// res = 0
//
// for right = 0 to n-1:
//     freq[s[right] - 'A']++
//     maxFreq = max(maxFreq, freq[s[right] - 'A'])
//
//     if (right-left+1)-maxFreq > k:
//         freq[s[left] - 'A']--
//         left++
//
//     res = max(res, right-left+1)
//
// return res

TC: O(n)
SC: O(1) — fixed 26-element array


----------------------------------------------------------
BEST INTERVIEW IMPLEMENTATION
----------------------------------------------------------

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            int windowLength = right - left + 1;

            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}


----------------------------------------------------------
WHY DON'T WE DECREASE maxFreq?
----------------------------------------------------------

maxFreq stores the maximum frequency observed as the
window expands. It may become stale after left moves.

Normally, we might recalculate the true maximum frequency
of the current window, but that would cost O(26) per step.
Here, we deliberately avoid recalculating it.

Why this works:
- maxFreq never decreases.
- The window's validity check may temporarily accept a
  window that is not truly valid.
- But this stale value does not cause the algorithm to
  overestimate the FINAL maximum length.
- When the window is invalid, we shrink it by one.
  The window length therefore stays the same or grows
  by one on each iteration.
- A stale maxFreq can prevent shrinking as aggressively
  as an exact count would, but it does not create a
  larger answer than the maximum achievable length.

Important:
This reasoning relies on finding the maximum length,
not enumerating every valid window.


----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• Why use an int[26]?
  The problem guarantees uppercase English letters A-Z.

• Why not use a HashMap?
  A fixed-size frequency array is simpler and has
  constant space for this alphabet.

• What if lowercase letters are allowed?
  Normalize the characters or map the appropriate
  character range to array indices.

• What if we need every valid substring?
  The stale maxFreq optimization is not suitable for
  enumerating all valid windows; maintain exact counts.

• Can we shrink using while instead of if?
  Yes, with a recomputed exact maximum frequency.
  With stale maxFreq, the standard one-step if version
  is the usual optimized solution for this problem.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• "" -> 0
• "AAAA", k = 0 -> 4
• "ABAB", k = 2 -> 4
• "AABABBA", k = 1 -> 4
• k = 0 -> longest run of identical characters
• k >= s.length() -> s.length()


----------------------------------------------------------
REMEMBER
----------------------------------------------------------

• replacementsNeeded = windowLength - maxFreq.
• Valid when replacementsNeeded <= k.
• Invalid when replacementsNeeded > k.
• Use uppercase mapping: ch - 'A'.
• Sliding window is O(n); each pointer moves forward.
• maxFreq is intentionally NOT decreased in the optimized
  solution. It is a historical maximum, not necessarily
  the exact maximum frequency in the current window.

==========================================================
*/

}
