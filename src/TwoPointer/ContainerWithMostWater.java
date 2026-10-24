package TwoPointer;

public class ContainerWithMostWater {

/*
==========================================================
Problem: Container With Most Water (LeetCode 11)
Pattern: Two Pointers | Greedy
==========================================================

INTUITION
---------
Choose two heights that form a container holding the
maximum amount of water.

Area = min(leftHeight, rightHeight) * width

Width = right - left

The shorter boundary limits the water capacity.


----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
Try every possible pair and calculate its area.

Pseudo:
// maxArea = 0
// for i = 0 to n-2:
//     for j = i+1 to n-1:
//         height = min(nums[i], nums[j])
//         area = height * (j-i)
//         maxArea = max(maxArea, area)
// return maxArea

TC: O(n^2)
SC: O(1)


----------------------------------------------------------
APPROACH 2 - Optimal: Two Pointers
----------------------------------------------------------

Idea:
Start with the widest possible container.

1. Calculate the current area.
2. Update the maximum.
3. Move the pointer at the SHORTER height.
4. Repeat until pointers meet.

Pseudo:
// left = 0, right = n-1
// maxArea = 0
//
// while left < right:
//     area = min(nums[left], nums[right]) * (right-left)
//     maxArea = max(maxArea, area)
//
//     if nums[left] < nums[right]:
//         left++
//     else:
//         right--
//
// return maxArea

TC: O(n)
SC: O(1)


----------------------------------------------------------
BEST INTERVIEW IMPLEMENTATION
----------------------------------------------------------

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right])
                       * (right - left);

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}


----------------------------------------------------------
WHY MOVE THE SHORTER POINTER?
----------------------------------------------------------

Area = shorter height * width.

Moving either pointer reduces the width.

If we move the taller pointer:
- The shorter height remains the limiting boundary.
- Width decreases.
- Area cannot improve beyond the current area.

If we move the shorter pointer:
- We might find a taller boundary.
- This may compensate for the reduced width.

Therefore, always move the shorter boundary.

If both heights are equal, moving either one is valid.
Your code moves the right pointer in this case.


----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• Why not sort the array?
  Original positions determine width; sorting destroys them.

• Can the answer be zero?
  Yes, for arrays with fewer than two elements or
  when all heights are zero.

• Can this be solved in O(n)?
  Yes, using two pointers.

• Why is it greedy?
  We discard a boundary that cannot improve the area
  while keeping the other boundary fixed.

• Is the optimal algorithm stable for duplicates?
  Yes. Equal heights are handled by moving either pointer.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• [] or [5] -> 0
• [1, 1] -> 1
• All heights zero -> 0
• Increasing heights
• Decreasing heights
• Equal heights
• Maximum height and width under problem constraints


----------------------------------------------------------
REMEMBER
----------------------------------------------------------

• Area = min(height[left], height[right]) * width.
• Start with maximum width.
• Move the shorter boundary.
• Update maxArea before moving pointers.
• Do not sort the array.
• Your variable name `contianer` has a typo;
  `area` is clearer.

Java note:
If input constraints allow very large heights and widths,
use long for the area to avoid int overflow. Standard
LeetCode constraints fit within int.

----------------------------------------------------------
COMPLEXITY
----------------------------------------------------------

Brute Force : O(n^2) time, O(1) space
Optimal     : O(n) time, O(1) space

==========================================================
*/

}
