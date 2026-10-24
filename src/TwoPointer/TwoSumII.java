package TwoPointer;

public class TwoSumII {

/*
==========================================================
Problem: Two Sum II - Input Array Is Sorted (LC 167)
Pattern: Two Pointers
==========================================================

INTUITION
---------
Array is sorted.

- sum == target -> return indices
- sum > target  -> move right leftward to decrease sum
- sum < target  -> move left rightward to increase sum

Important: Return 1-based indices.

----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
// for i from 0 to n-1:
//     for j from i+1 to n-1:
//         if nums[i] + nums[j] == target:
//             return {i+1, j+1}

TC: O(n^2)
SC: O(1) auxiliary

----------------------------------------------------------
APPROACH 2 - HashMap
----------------------------------------------------------

Idea:
// for each index i:
//     complement = target - nums[i]
//     if complement exists in map:
//         return {map[complement]+1, i+1}
//     map[nums[i]] = i

TC: O(n) average
SC: O(n)

Note:
Works even if the array is unsorted, but uses extra space.

----------------------------------------------------------
APPROACH 3 - Optimal: Two Pointers
----------------------------------------------------------

Idea:
// left = 0, right = n-1
// while left < right:
//     sum = nums[left] + nums[right]
//     if sum == target: return {left+1, right+1}
//     if sum > target: right--
//     else: left++
//
// return {}

TC: O(n)
SC: O(1) auxiliary

----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

- Why move right when sum > target?
  The right value is too large; moving left decreases
  or maintains the sum because the array is sorted.

- Why move left when sum < target?
  The left value is too small; moving right increases
  or maintains the sum.

- Why not use two pointers on an unsorted array?
  The direction-based logic depends on sorted order.
  Sorting the array can also destroy original indices.

- Why left < right?
  Both indices must refer to distinct elements.

----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

- Two elements only
- Negative values
- Duplicate values, e.g. [1, 1], target = 2
- Target is smaller/larger than many possible sums
- No solution, if the problem allows that input

----------------------------------------------------------
REMEMBER
----------------------------------------------------------

- Two Sum I (unsorted): HashMap is usually optimal.
- Two Sum II (sorted): Two pointers are optimal.
- Return {left + 1, right + 1}, not zero-based indices.
- The array must be sorted for this pointer logic.
- Your method assumes a valid pair exists if the problem
  guarantees one; otherwise {} is a reasonable fallback.

==========================================================
*/

}
