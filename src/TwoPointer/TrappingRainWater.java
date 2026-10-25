package TwoPointer;

public class TrappingRainWater {

/*
==========================================================
Problem: Trapping Rain Water (LeetCode 42)
Pattern: Two Pointers | Prefix/Suffix Max | Monotonic Stack
==========================================================

INTUITION
---------
Water above index i depends on the tallest wall on
its left and right.

water[i] = min(leftMax, rightMax) - height[i]

Total water = sum of water[i] for every index.

----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
For each index, scan left and right to find the maximum
height on each side.

Pseudo:
// water = 0
// for i = 0 to n-1:
//     leftMax = maximum height from index 0 to i
//     rightMax = maximum height from index i to n-1
//     water += min(leftMax, rightMax) - height[i]
// return water

TC: O(n^2)
SC: O(1)

----------------------------------------------------------
APPROACH 2 - Prefix + Suffix Arrays
----------------------------------------------------------

Idea:
Precompute the maximum height to the left and right
of every index, then calculate trapped water.

Pseudo:
// prefix[0] = height[0]
// for i = 1 to n-1:
//     prefix[i] = max(prefix[i-1], height[i])
//
// suffix[n-1] = height[n-1]
// for i = n-2 down to 0:
//     suffix[i] = max(suffix[i+1], height[i])
//
// for i = 0 to n-1:
//     water += min(prefix[i], suffix[i]) - height[i]
//
// return water

TC: O(n)
SC: O(n)

----------------------------------------------------------
APPROACH 3 - Monotonic Stack
----------------------------------------------------------

Idea:
Maintain indices of bars in a monotonic stack.

When the current bar is taller than a bar on the stack,
that popped bar can be the bottom of a water container.

After popping:
- Stack top = left boundary
- Current index = right boundary
- Popped index = bottom

Pseudo:
// for i = 0 to n-1:
//     while stack not empty AND height[i] >= height[top]:
//         bottom = pop()
//
//         if stack empty: break
//
//         left = stack.peek()
//         boundedHeight = min(height[left], height[i])
//                         - height[bottom]
//         width = i - left - 1
//         water += boundedHeight * width
//
//     push i
//
// return water

TC: O(n)
SC: O(n)

Each index is pushed once and popped at most once.

Using Deque<Integer> with
ArrayDeque<Integer> is preferred over legacy Stack<Integer>.


----------------------------------------------------------
APPROACH 4 - Optimal: Two Pointers
----------------------------------------------------------

Idea:
Use left and right pointers, tracking the maximum
height seen from each side.

If height[left] < height[right]:
    The left side determines the water level at left.
    Process left and move it forward.

Otherwise:
    The right side determines the water level at right.
    Process right and move it backward.

Pseudo:
// left = 0, right = n-1
// leftMax = 0, rightMax = 0
// water = 0
//
// while left < right:
//     if height[left] < height[right]:
//         leftMax = max(leftMax, height[left])
//         water += leftMax - height[left]
//         left++
//     else:
//         rightMax = max(rightMax, height[right])
//         water += rightMax - height[right]
//         right--
//
// return water

TC: O(n)
SC: O(1)


----------------------------------------------------------
BEST INTERVIEW IMPLEMENTATION
----------------------------------------------------------

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}


----------------------------------------------------------
WHY DOES THE TWO-POINTER APPROACH WORK?
----------------------------------------------------------

The smaller current boundary determines which side
can safely be processed.

If height[left] < height[right]:
    The right boundary is taller than the current left.
    The water at left is determined by leftMax, because
    the right boundary already provides sufficient height.

The right side follows the symmetric reasoning.

Important:
Update the maximum BEFORE adding trapped water.

----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• Why is brute force O(n^2)?
  Each index scans the array on both sides.

• Why is prefix/suffix O(n)?
  Two preprocessing passes and one calculation pass.

• Why is the stack O(n)?
  Each index enters and leaves the stack at most once.

• Why is two-pointer space O(1)?
  Only pointers, maxima, and a running total are stored.

• Why use indices in the stack?
  We need both boundary heights and the width between them.

• Can water be negative?
  No. The running maximum on each side is always at least
  the current height, so trapped water is non-negative.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• [] -> 0
• [1, 2, 3] -> 0
• [3, 2, 1] -> 0
• [3, 0, 3] -> 3
• [4, 2, 0, 3, 2, 5] -> 9
• Equal-height bars
• Single bar or two bars -> 0

Your prefix/suffix solution accesses prefix[0] and
suffix[n-1], so add an empty-array guard if empty input
is allowed. The two-pointer solution already returns 0
for an empty array.


----------------------------------------------------------
REMEMBER
----------------------------------------------------------

• Water at i = min(leftMax, rightMax) - height[i].
• Brute force: O(n^2), O(1).
• Prefix/suffix: O(n), O(n).
• Monotonic stack: O(n), O(n).
• Two pointers: O(n), O(1) — best overall.
• Monotonic stack stores indices, not heights.
• In the stack approach, width = right - left - 1.
• In the two-pointer approach, process the shorter side.
• Your prefix/suffix variable name is usually spelled
  prefix, not preffix.

==========================================================
*/

}
