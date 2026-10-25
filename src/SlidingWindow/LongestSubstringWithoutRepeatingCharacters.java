package SlidingWindow;

public class LongestSubstringWithoutRepeatingCharacters {

/*
==========================================================
Problem: Longest Substring Without Repeating Characters
LeetCode: 3
Pattern: Sliding Window | HashSet | HashMap
==========================================================

INTUITION
---------
Find the longest CONTIGUOUS substring with no repeated
characters.

Example:
Input:  "abcabcbb"
Output: 3
Reason: "abc"

A sliding window [left, right] represents the current
substring. Expand right; move left when a duplicate
violates the condition.


----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
Start at every index and extend the substring until
a duplicate appears.

Pseudo:
// maxLength = 0
// for i = 0 to n-1:
//     seen = empty set
//     for j = i to n-1:
//         if s[j] is already in seen: break
//         add s[j] to seen
//         maxLength = max(maxLength, j-i+1)
// return maxLength

TC: O(n^2) average
SC: O(k) auxiliary for the set

Your Solution 1 is correct.


----------------------------------------------------------
APPROACH 2 - Sliding Window + HashSet
----------------------------------------------------------

Idea:
Maintain a window with unique characters.

When the incoming character already exists:
remove characters from the left until that duplicate
is removed.

Pseudo:
// left = 0, maxLength = 0
// seen = empty set
//
// for right = 0 to n-1:
//     while s[right] is in seen:
//         remove s[left] from seen
//         left++
//     add s[right] to seen
//     maxLength = max(maxLength, right-left+1)
//
// return maxLength

TC: O(n) average
SC: O(k)

Why O(n)?
Each character enters the set once and leaves at most
once. The while loop does not make the algorithm O(n²).

Your Solution 2 is correct.


----------------------------------------------------------
APPROACH 3 - Sliding Window + HashMap
----------------------------------------------------------

Idea:
Store each character's most recent index.

If a duplicate appears inside the current window,
jump left directly past its previous occurrence.

Pseudo:
// left = 0, maxLength = 0
// map = character -> most recent index
//
// for right = 0 to n-1:
//     ch = s[right]
//     if ch exists in map:
//         left = max(left, map[ch] + 1)
//     map[ch] = right
//     maxLength = max(maxLength, right-left+1)
//
// return maxLength

TC: O(n) average
SC: O(k)

BEST GENERAL-PURPOSE INTERVIEW VERSION:

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            Integer prev = lastSeen.get(ch);
            if (prev != null) {
                left = Math.max(left, prev + 1);
            }

            lastSeen.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

Important:
Use max(left, prev + 1), not simply prev + 1.
The previous occurrence may be outside the current window.


----------------------------------------------------------
APPROACH 4 - Last-Seen Array (Your Solution)
----------------------------------------------------------

Idea:
Replace the HashMap with an array indexed by character.

Store index + 1, so zero means "never seen".

Why index + 1?
Java int[] elements default to 0. This avoids confusing
a character found at index 0 with a character never seen.

Pseudo:
// seen = int[128] initialized to zero
// left = 0, maxLength = 0
//
// for right = 0 to n-1:
//     ch = s[right]
//
//     if seen[ch] > left:
//         left = seen[ch]
//
//     seen[ch] = right + 1
//     maxLength = max(maxLength, right-left+1)
//
// return maxLength

TC: O(n)
SC: O(1) for a fixed ASCII alphabet

Your Solution 4 is correct for ASCII input.


----------------------------------------------------------
UNDERSTANDING THE ARRAY TRICK
----------------------------------------------------------

Example: "abba"

Initially:
left = 0
seen['a'] = 0

At right = 0, 'a':
seen['a'] = 1
Window = "a", length = 1

At right = 1, 'b':
seen['b'] = 2
Window = "ab", length = 2

At right = 2, 'b':
seen['b'] = 2
left = 2
Window = "b", length = 1

At right = 3, 'a':
seen['a'] = 1
left = max(2, 1) = 2
Window = "ba", length = 2

Answer = 2

Key:
seen[ch] stores the PREVIOUS index + 1.
left is the first valid index of the current window.

If seen[ch] > left, the previous occurrence is inside
the current window, so move left forward.


----------------------------------------------------------
COMPLEXITY COMPARISON
----------------------------------------------------------

Brute Force:
TC: O(n^2) average
SC: O(k)

HashSet Sliding Window:
TC: O(n) average
SC: O(k)

HashMap Last-Seen:
TC: O(n) average
SC: O(k)

Array Last-Seen:
TC: O(n)
SC: O(1) for a fixed-size alphabet


----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• Why is the substring contiguous?
  A substring must contain consecutive characters.

• Why use max(left, prev+1)?
  Never move left backward when a repeated character
  occurred before the current window.

• Why use right-left+1?
  Both boundaries are inclusive.

• Can the HashSet solution jump left directly?
  Not with only membership information; it doesn't
  store where each character occurred.

• Why use an array instead of a HashMap?
  Direct indexing avoids hashing and boxing overhead.

• Does int[128] support every Java char?
  No. It supports only character values 0 through 127.

• What about Unicode?
  A Java char represents a UTF-16 code unit. For full
  Unicode code-point handling, use codePoints() and
  account for code-point indices separately.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• ""          -> 0
• "a"         -> 1
• "aaaa"      -> 1
• "abcabcbb"  -> 3
• "bbbbb"     -> 1
• "pwwkew"    -> 3 ("wke")
• "abba"      -> 2

----------------------------------------------------------
REMEMBER
----------------------------------------------------------

• Sliding window = contiguous range.
• HashSet approach: remove from left until valid.
• HashMap approach: jump left past the last occurrence.
• Array approach: seen[ch] = index + 1.
• HashMap: use max(left, previousIndex + 1).
• Window length = right - left + 1.
• Every character is processed O(1) times on average
  in the sliding-window approaches.

==========================================================
*/

}
