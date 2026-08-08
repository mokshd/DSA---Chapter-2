package ArrayHashing;

public class ValidAnagram {
    /*
==========================================================
Problem: 242. Valid Anagram
Pattern: Hashing | Frequency Count | Sorting
==========================================================

INTUITION
---------
Anagrams have:
• Same length
• Same character frequency

----------------------------------------------------------

APPROACH 1 - Sorting
--------------------
Idea:
Sort both strings and compare.

Pseudo:
// if lengths differ -> false
// sort(s)
// sort(t)
// return Arrays.equals()

TC: O(n log n)
SC: O(n)    // char[] conversion

----------------------------------------------------------

APPROACH 2 - HashMap
--------------------
Idea:
Count chars from s, decrement using t.

Pseudo:
// build frequency map from s
// decrement using t
// count < 0 -> false
// remove count==0
// map empty -> true

TC: O(n)
SC: O(k)   // k = unique characters

----------------------------------------------------------

APPRO----------

APPROACH 3 - Frequency Array (Optimal)
--------------------------------------
Idea:
Increment for s, decrement for t.
All counts must become 0.

Pseudo:
// if lengths differ -> false
// int[26] freq
// ++freq[s[i]-'a']
// --freq[t[i]-'a']
// if any freq != 0 -> false
// return true

TC: O(n)
SC: O(1)

----------------------------------------------------------

FOLLOW-UPS
----------
• Unicode characters? -> Use HashMap instead of int[26].
• Case insensitive? -> Convert both to lower/upper case first.
• Ignore spaces/punctuation? -> Preprocess strings first.

EDGE CASES
----------
• Different lengths
• Empty strings
• Repeated characters
• Same strings

REMEMBER
--------
• int[26] works only for lowercase 'a' to 'z'.
• Early length check avoids unnecessary work.
• HashMap works for any character set.
• Arrays.equals() compares array contents, not references.
• s.charAt(i) - 'a' gives index 0-25.

COMPLEXITY
----------
Sorting    : O(n log n)  O(n)
HashMap    : O(n)        O(k)
Freq Array : O(n)        O(1)

==========================================================
*/
}
