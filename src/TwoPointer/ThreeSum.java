package TwoPointer;

public class ThreeSum {

/*
==========================================================
Problem: 3Sum (LeetCode 15)
Pattern: Sorting + Two Pointers | Duplicate Handling
==========================================================

INTUITION
---------
Find all UNIQUE triplets whose sum is 0.

For each nums[i]:
    Find two numbers after i whose sum = -nums[i].

Sorting enables two pointers:
    sum < 0 -> move left forward
    sum > 0 -> move right backward
    sum == 0 -> record triplet and move both pointers

Example:
Input:  [-1, 0, 1, 2, -1, -4]
Output: [[-1, -1, 2], [-1, 0, 1]]


----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
Try every possible triplet and store only unique triplets.

Pseudo:
// for i = 0 to n-2:
//   for j = i+1 to n-1:
//     for k = j+1 to n:
//       if nums[i] + nums[j] + nums[k] == 0:
//         sort triplet
//         if triplet not seen:
//           add to result

TC: O(n^3) average, with constant-size triplet sorting
SC: O(n^2) worst case for stored unique triplets

Your Solution 1:
Correct, but building a String key for every match adds
allocation and hashing overhead.


----------------------------------------------------------
APPROACH 2 - HashSet
----------------------------------------------------------

Idea:
Fix one number, then use a HashSet to find whether
the complement of the current number has been seen.

Pseudo:
// for i = 0 to n-2:
//   create empty set
//   for j = i+1 to n-1:
//     complement = -nums[i] - nums[j]
//     if complement in set:
//       normalize triplet and add if globally unique
//     add nums[j] to set

TC: O(n^2) average
SC: O(n^2) worst case including stored results

Note:
Deduplication still needs care. A set of normalized
triplets can prevent duplicates.

Alternative:
Sort + binary search for the third number.

TC: O(n^2 log n)
SC: Depends on duplicate tracking and result storage.


----------------------------------------------------------
APPROACH 3 - Optimal: Sorting + Two Pointers
----------------------------------------------------------

Idea:
1. Sort the array.
2. Fix index i.
3. Set left = i + 1, right = n - 1.
4. Compare the sum with zero.
5. After a match, move both pointers and skip duplicates.

Pseudo:
// sort nums
//
// for i = 0 to n-3:
//   if i > 0 && nums[i] == nums[i-1]: continue
//   if nums[i] > 0: break
//
//   left = i+1
//   right = n-1
//
//   while left < right:
//     sum = nums[i] + nums[left] + nums[right]
//
//     if sum == 0:
//       add triplet
//       left++
//       right--
//       skip duplicate left values
//       skip duplicate right values
//
//     else if sum < 0:
//       left++
//     else:
//       right--
//
// return result

TC: O(n^2)
SC: O(1) auxiliary, excluding output
    Sorting may use implementation-dependent stack space.


----------------------------------------------------------
BEST INTERVIEW IMPLEMENTATION
----------------------------------------------------------

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));

                    left++;
                    right--;

                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}


----------------------------------------------------------
WHY THE POINTER MOVEMENTS WORK
----------------------------------------------------------

Array is sorted.

sum < 0:
    Increase left to increase the sum.

sum > 0:
    Decrease right to decrease the sum.

sum == 0:
    Save the triplet and move BOTH pointers because
    the current pair has already been used.


----------------------------------------------------------
DUPLICATE HANDLING - CRITICAL
----------------------------------------------------------

1. Skip duplicate fixed values:
   if (i > 0 && nums[i] == nums[i-1]) continue;

2. After a match, move both pointers.

3. Skip duplicate left values:
   nums[left] == nums[left-1]

4. Skip duplicate right values:
   nums[right] == nums[right+1]

Why skip duplicates?
The problem requires unique triplets, not unique indices.

Why check i > 0?
Prevents accessing nums[-1] on the first iteration.


----------------------------------------------------------
OPTIMIZATIONS
----------------------------------------------------------

• Loop only while i < n-2; at least two elements must
  remain for the two pointers.

• If nums[i] > 0, break: all remaining numbers are
  non-negative, so no triplet can sum to zero.

• Use break rather than return res for early termination.
  Both are correct here; break exits only the outer loop.

• Sorting modifies the input array.

• For extreme integer values, use long for the sum to
  prevent integer overflow. Standard problem constraints
  generally allow int.


----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• 3Sum closest?
  Keep the sum closest to target while moving pointers.

• 4Sum?
  Fix two numbers, then use two pointers; typical O(n^3).

• 3Sum with target T?
  Compare sum against T instead of zero.

• Can we solve in O(n log n)?
  Not with this standard general-purpose approach;
  the usual interview solution is O(n^2).

• Why not use a HashSet for the final solution?
  It can work, but sorting + two pointers handles
  duplicate values more directly.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• Empty or fewer than 3 elements -> []
• All positive numbers -> []
• All negative numbers -> []
• Duplicate values, e.g. [0, 0, 0, 0] -> [[0, 0, 0]]
• Multiple valid triplets
• Already sorted or reverse-sorted input


----------------------------------------------------------
REMEMBER
----------------------------------------------------------

3Sum = SORT + FIX ONE + TWO POINTERS.

Brute force: O(n^3)
Optimal:     O(n^2)

The hardest part is duplicate handling:
- Skip duplicate i values before searching.
- After a match, skip duplicate left and right values.

==========================================================
*/

}
