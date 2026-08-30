package ArrayHashing;

public class LongestConsecutiveSequence {
    /*
==========================================================
Problem: 128. Longest Consecutive Sequence
Pattern: HashSet | Sorting
==========================================================

APPROACH 1 - Brute Force
------------------------
Idea:
For every number, keep checking whether next number exists.

Pseudo:
// for each num
//     current = num
//     count = 1
//     while array contains current + 1
//         current++
//         count++
//     max = max(max, count)

TC: O(n²)
SC: O(1)

----------------------------------------------------------

APPROACH 2 - Sorting
--------------------
Idea:
Sort -> consecutive numbers will be adjacent.
Skip duplicates and reset count when sequence breaks.

Pseudo:
// sort(nums)
// count = 1
// for i = 1 -> n-1
//     if nums[i] == nums[i-1]
//         continue
//     if nums[i] == nums[i-1] + 1
//         count++
//     else
//         count = 1
//     max = max(max, count)

TC: O(n log n)
SC: O(1)*

*Ignoring sorting implementation space.

----------------------------------------------------------

APPROACH 3 - HashSet (Optimal)
------------------------------
Idea:
Put all numbers in a Set.
Only start counting from the BEGINNING of a sequence
(number-1 does not exist).

Pseudo:
// add all nums to HashSet
//
// for each num in set
//     if set contains num-1
//         continue       // not sequence start
//
//     current = num
//     count = 1
//     while set contains current+1
//         current++
//         count++
//
//     max = max(max, count)
//
// return max

TC: O(n) average
SC: O(n)

WHY O(n)?
Each sequence is traversed only from its starting point.
Numbers that have a predecessor are skipped.

----------------------------------------------------------

FOLLOW-UPS
----------
• O(1) extra space? -> Sorting
• O(n) time? -> HashSet
• Duplicates? -> HashSet automatically ignores them.
• Negative numbers? -> Works normally.
• Empty array? -> return 0.
• Can array be modified? -> If yes, sorting is possible.

----------------------------------------------------------

EDGE CASES
----------
• []
• [1]
• [1,2,3,4]
• [1,1,2,2,3]
• [100,4,200,1,3,2]
• Negative numbers

----------------------------------------------------------

REMEMBER
--------
• Only start sequence when `num - 1` is NOT present.
• HashSet removes duplicate impact automatically.
• Duplicates don't create a new consecutive sequence;
  they represent the same value.
• No need to track positions unless the problem asks for
  indices/subarray positions.
• `Set` iteration order doesn't matter.

IMPORTANT BUG
-------------
Don't use `value` before declaring it.

Wrong:
// if (set.contains(value - 1)) continue;
// int value = x;

Correct:
// int value = x;
// if (set.contains(value - 1)) continue;

----------------------------------------------------------

COMPLEXITY
----------
Brute Force : O(n²)      O(1)
Sorting     : O(n log n) O(1)*
HashSet     : O(n)       O(n)

==========================================================
*/
}
