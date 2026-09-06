package Stack;

public class DailyTemperatures {
    /*
==========================================================
Problem: 739. Daily Temperatures
Pattern: Monotonic Stack | Next Greater Element
==========================================================

INTUITION
---------
For each day, find the next day with a HIGHER temperature.

Stack stores INDICES of unresolved days.
Maintain temperatures in DECREASING order.

When current temperature is higher than stack top,
current day is the answer for that previous day.

----------------------------------------------------------

APPROACH 1 - Brute Force
------------------------
Idea:
For every day, scan all following days until a warmer
temperature is found.

Pseudo:
// for i = 0 -> n-1
//     for j = i+1 -> n-1
//         if temp[j] > temp[i]
//             result[i] = j-i
//             break

TC: O(n²)
SC: O(1) extra

----------------------------------------------------------

APPROACH 2 - Monotonic Stack (Optimal)
--------------------------------------
Idea:
Store indices of days waiting for a warmer temperature.

Pseudo:

// stack = indices of unresolved days
//
// for i = 0 -> n-1:
//
//     while stack not empty
//           AND temp[i] > temp[stack.peek()]
//
//         index = stack.pop()
//         result[index] = i - index
//
//     stack.push(i)
//
// return result

TC: O(n)
SC: O(n)

WHY O(n)?
---------
Each index is:
// pushed once
// popped at most once

=> O(n), NOT O(n²)

----------------------------------------------------------

STACK PROPERTY
--------------
Stack contains indices whose temperatures are in
DECREASING order.

Example:
[73, 74, 75]

73 -> stack [0]
74 > 73 -> pop 0 -> answer[0] = 1
75 -> pop 1 -> answer[1] = 1

----------------------------------------------------------

FOLLOW-UPS
----------
• What if we need the NEXT SMALLER temperature?
  -> Reverse the comparison/stack condition.

• Return actual temperature instead of days?
  -> Store temperatures or use index to access it.

• Can this be solved from right to left?
  -> Yes, maintain a monotonic stack of useful candidates.

• Why store indices instead of temperatures?
  -> Need `i - index` for number of days.

----------------------------------------------------------

EDGE CASES
----------
• Empty array
• Single temperature
• Strictly increasing
• Strictly decreasing
• All temperatures equal
• Last day -> remains 0

----------------------------------------------------------

REMEMBER
--------
• "Next greater element" -> Monotonic Stack.
• Store INDICES, not values.
• Stack = unresolved days.
• Higher current temp resolves previous days.
• `res[index] = i - index`.
• Remaining elements stay 0.
• Java int[] is automatically initialized to 0.

----------------------------------------------------------

COMPLEXITY
----------
Brute Force : O(n²)  O(1)
Stack       : O(n)   O(n)

==========================================================
*/
}
