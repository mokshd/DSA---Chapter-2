package SlidingWindow;

public class PermutationInString {

/*
==========================================================
Problem: Permutation in String (LeetCode 567)
Pattern: Sliding Window + Frequency Array
==========================================================

INTUITION
---------
Check whether s2 contains a substring that is a
permutation of s1.

Key observations:
- A permutation has the same characters and frequencies.
- Order does not matter.
- The substring length must equal s1.length().

Example:
s1 = "ab"
s2 = "eidbaooo"

Output: true
Reason: "ba" is a permutation of "ab".


----------------------------------------------------------
APPROACH 1 - Brute Force: Sort Every Window
----------------------------------------------------------

Idea:
1. Sort s1 once.
2. Generate every substring of length n from s2.
3. Sort each substring.
4. Compare the sorted character arrays.

Pseudo:
// target = sorted characters of s1
//
// for i = 0 to m-n:
//     window = s2.substring(i, i+n)
//     sort(window)
//     if window == target:
//         return true
//
// return false

TC: O(n log n + (m-n+1) * n log n)
SC: O(n)

Your Solution 1 is correct.

Note:
A theoretical alternative is generating all permutations
of s1 and searching for each in s2, but that is factorial
and significantly worse.


----------------------------------------------------------
APPROACH 2 - Frequency Array for Every Window
----------------------------------------------------------

Idea:
1. Build frequency array for s1.
2. For every window of length n in s2:
   - Create a fresh frequency array.
   - Count characters in that window.
   - Compare both arrays.

Pseudo:
// freq1 = frequency of s1
//
// for each window of length n in s2:
//     freq2 = new int[26]
//     count all characters in current window
//     if freq1 == freq2:
//         return true
//
// return false

TC: O(n + (m-n+1) * (n+26))
//    O(m*n) for the general input sizes

SC: O(26) = O(1)

Your Solution 2 is correct.

Problem:
We repeatedly count all n characters for every window.
Most characters overlap with the previous window.


----------------------------------------------------------
APPROACH 3 - Optimal: Sliding Window + Frequency Array
----------------------------------------------------------

Idea:
Maintain two frequency arrays:
- freq1: frequency of s1
- freq2: frequency of current window in s2

Expand the window by adding the right character.

Once window size reaches n:
1. Compare both frequency arrays.
2. If equal, return true.
3. Otherwise remove the left character.
4. Move left forward.

Pseudo:
// freq1 = frequency of s1
// freq2 = empty frequency array
// left = 0
//
// for right = 0 to m-1:
//     freq2[s2[right]]++
//
//     if right-left+1 == n:
//         if freq1 == freq2:
//             return true
//
//         freq2[s2[left]]--
//         left++
//
// return false

TC: O(n + 26*m) = O(m+n)
// Because alphabet size is fixed at 26.

SC: O(26) = O(1)

Your Solution 3 is correct.


----------------------------------------------------------
BEST INTERVIEW IMPLEMENTATION
----------------------------------------------------------

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < m; right++) {
            freq2[s2.charAt(right) - 'a']++;

            if (right - left + 1 == n) {
                if (Arrays.equals(freq1, freq2)) {
                    return true;
                }

                freq2[s2.charAt(left) - 'a']--;
                left++;
            }
        }

        return false;
    }
}


----------------------------------------------------------
APPROACH 4 - Optimized: Frequency Difference / Matches
----------------------------------------------------------

Idea:
Instead of comparing all 26 frequency entries for every
window, maintain how many character frequencies match.

Alternative:
Maintain a difference array:
diff[c] = freq1[c] - freqWindow[c]

When all 26 differences are zero, a permutation exists.

Pseudo:
// Build diff using s1
// Subtract first n characters of s2
// matches = number of indices where diff[index] == 0
//
// For each next window:
//     update outgoing character's difference
//     update incoming character's difference
//     if matches == 26:
//         return true
//
// return false

TC: O(n + m + 26) = O(m+n)
SC: O(26) = O(1)

Note:
This is an optimization of the frequency-array approach.
It avoids Arrays.equals() on every window, but adds
bookkeeping complexity.

For interviews, Approach 3 is usually sufficient.


----------------------------------------------------------
WHY FIXED-SIZE SLIDING WINDOW?
----------------------------------------------------------

The required substring must have exactly n characters.

Therefore:
- Add one character from the right.
- When window size becomes n, compare frequencies.
- Remove the outgoing left character.
- Move left forward.

The window never needs to grow beyond n.

----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• Why compare frequency arrays instead of sorting?
  Frequency comparison avoids sorting every window.

• Why use int[26]?
  Problem guarantees lowercase English letters a-z.

• Why does Arrays.equals() work?
  It compares corresponding array elements.

• Why remove the left character after comparison?
  To prepare the next window of the same length.

• Can we use HashMap?
  Yes, but an array is simpler and more efficient
  for a fixed 26-character alphabet.

• Difference between this and Longest Substring
  Without Repeating Characters?
  That problem uses a variable-size window.
  This problem uses a fixed-size window.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• s1.length() > s2.length() -> false
• s1 = "ab", s2 = "eidbaooo" -> true
• s1 = "ab", s2 = "eidboaoo" -> false
• s1 = "a", s2 = "a" -> true
• s1 = "a", s2 = "b" -> false
• Repeated characters: s1 = "aabc"
• Exact match at beginning or end


----------------------------------------------------------
REMEMBER
----------------------------------------------------------

• Permutation means same character frequencies.
• Window size must equal s1.length().
• Fixed-size sliding window.
• Add incoming character.
• Compare frequency arrays.
• Remove outgoing character.
• Arrays.equals() compares array contents, not references.
• int[26] works for lowercase English letters only.
• Do not rebuild the frequency array for every window.

----------------------------------------------------------
COMPLEXITY COMPARISON
----------------------------------------------------------

Brute (sorting) : O(m*n*log n), O(n)
Frequency rebuild: O(m*n), O(1)
Sliding window   : O(m+n), O(1)
Matches optimized: O(m+n), O(1)

==========================================================
*/

}
