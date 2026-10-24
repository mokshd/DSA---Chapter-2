package TwoPointer;

public class ValidPalindrome {

/*
==========================================================
Problem: Valid Palindrome (LeetCode 125)
Pattern: Two Pointers | String Manipulation
==========================================================

INTUITION
---------
A palindrome reads the same forward and backward.

Rules:
- Ignore non-alphanumeric characters.
- Ignore uppercase/lowercase differences.
- Compare only letters and digits.

Example:
Input:  "A man, a plan, a canal: Panama"
Output: true

----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
Create a cleaned string containing only alphanumeric
characters in lowercase. Reverse it and compare.

Pseudo:
// cleaned = ""
// for each character c:
//     if c is letter or digit:
//         append lowercase(c) to cleaned
//
// reversed = reverse(cleaned)
// return cleaned.equals(reversed)

Java:
StringBuilder sb = new StringBuilder();

for (char c : s.toCharArray()) {
    if (Character.isLetterOrDigit(c)) {
        sb.append(Character.toLowerCase(c));
    }
}

String cleaned = sb.toString();
return cleaned.equals(sb.reverse().toString());

TC: O(n)
SC: O(n)

Note:
Your first solution follows this approach. Using
equalsIgnoreCase() makes explicit lowercasing unnecessary,
but normalizing once makes the comparison straightforward.


----------------------------------------------------------
APPROACH 2 - Better: Clean + Reverse
----------------------------------------------------------

Idea:
Build a string without punctuation, then compare it
against its reverse using case-insensitive comparison.

Pseudo:
// build cleaned string
// reversed = reverse(cleaned)
// return cleaned.equalsIgnoreCase(reversed)

TC: O(n)
SC: O(n)

Difference from brute:
Same asymptotic complexity. This is a simpler variation,
not a better time/space complexity.


----------------------------------------------------------
APPROACH 3 - Optimal: Two Pointers
----------------------------------------------------------

Idea:
Use left and right pointers directly on the original
string. Skip non-alphanumeric characters and compare
characters ignoring case.

Pseudo:
// left = 0, right = n - 1
//
// while left < right:
//     if s[left] is not alphanumeric:
//         left++
//     else if s[right] is not alphanumeric:
//         right--
//     else if lowercase(s[left]) != lowercase(s[right]):
//         return false
//     else:
//         left++
//         right--
//
// return true

Java:
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else if (Character.toLowerCase(l)
                    != Character.toLowerCase(r)) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}

TC: O(n)
SC: O(1) auxiliary space


----------------------------------------------------------
APPROACH COMPARISON
----------------------------------------------------------

Brute Force:
Clean + lowercase + reverse
TC: O(n), SC: O(n)

Better:
Clean + reverse + case-insensitive comparison
TC: O(n), SC: O(n)

Optimal:
Two pointers on original string
TC: O(n), SC: O(1) auxiliary space


----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

1. Why use two pointers?
   Avoids creating additional strings.

2. Why use Character.isLetterOrDigit()?
   Handles letters and digits while skipping punctuation
   and whitespace.

3. Why use Character.toLowerCase()?
   Makes comparison case-insensitive.

4. Why use left < right instead of left <= right?
   The middle character of an odd-length string needs
   no comparison with itself.

5. Can we compare characters directly?
   Yes, if case sensitivity is intended. Otherwise,
   normalize case or use a suitable case-insensitive
   comparison.

6. Is the two-pointer solution O(1) space?
   Yes, auxiliary space is O(1); the input string is
   not modified.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

- ""                     -> true
- " "                    -> true
- "a"                    -> true
- "A man, a plan, a canal: Panama" -> true
- "race a car"           -> false
- "0P"                   -> false
- ".,,"                  -> true


----------------------------------------------------------
REMEMBER
----------------------------------------------------------

- Two pointers are ideal when comparing both ends.
- Skip invalid characters BEFORE comparing.
- Use Character.isLetterOrDigit(c).
- Use Character.toLowerCase(c) for case-insensitive
  character comparison.
- StringBuilder.reverse() mutates the same builder.
- Save the original string before reversing if you need
  both versions.
- String comparison: use equals(), not ==.
- In Java, StringBuilder is mutable; String is immutable.

Unicode note:
Character.toLowerCase(char) works for typical interview
inputs, but cannot represent every Unicode case mapping
that expands to multiple characters. Follow the problem's
specified character constraints.

==========================================================
*/

}
