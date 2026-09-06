package Stack;

public class MinStack {
    /*
==========================================================
Problem: 155. Min Stack
Pattern: Stack | Auxiliary State
==========================================================

GOAL
----
Support:
push(), pop(), top(), getMin()

getMin() should ideally be O(1).

----------------------------------------------------------

APPROACH 1 - Brute Force
------------------------
Idea:
Use one stack.
Whenever getMin() is called, scan the whole stack.

Pseudo:
// push -> stack.push(val)
// pop  -> stack.pop()
// top  -> stack.peek()
//
// getMin:
//     min = MAX_VALUE
//     for each value in stack
//         min = Math.min(min, value)
//     return min

TC:
push   -> O(1)
pop    -> O(1)
top    -> O(1)
getMin -> O(n)

SC: O(n)

----------------------------------------------------------

APPROACH 2 - Two Stacks
-----------------------
Idea:
One stack stores values.
Second stack stores minimum at each level.

Pseudo:
// push(val):
//     stack.push(val)
//     minStack.push(
//         minStack.isEmpty()
//         ? val
//         : Math.min(val, minStack.peek())
//     )
//
// pop:
//     pop both stacks
//
// top:
//     return stack.peek()
//
// getMin:
//     return minStack.peek()

TC: O(1) all operations
SC: O(n)

----------------------------------------------------------

APPROACH 3 - Single Stack of Pair
---------------------------------
Idea:
Store:
[value, minimumTillHere]

Example:
push 5 -> [5,5]
push 3 -> [3,3]
push 7 -> [7,3]

Pseudo:
// push(val):
//     min = stack empty
//           ? val
//           : min(val, stack.peek()[1])
//
//     stack.push([val, min])
//
// top:
//     return stack.peek()[0]
//
// getMin:
//     return stack.peek()[1]

TC: O(1) all operations
SC: O(n)

----------------------------------------------------------

FOLLOW-UPS
----------
• Why store min at every level?
  -> After pop(), previous minimum is restored instantly.

• Duplicate minimum?
  -> Works automatically because min is stored per level.

• Two stacks vs pair stack?
  -> Same TC/SC; pair stack keeps value + min together.

• Can extra space be reduced further?
  -> Possible using encoded values/difference technique,
     but overflow handling makes it more complex.

----------------------------------------------------------

EDGE CASES
----------
• Single element
• Duplicate minimum
• Negative values
• Increasing/decreasing values
• Integer.MIN_VALUE / MAX_VALUE

----------------------------------------------------------

REMEMBER
--------
• Brute problem is only getMin() -> O(n).
• Store minimum AT EACH STACK LEVEL.
• `stack.peek()[0]` -> value
• `stack.peek()[1]` -> current minimum
• Pair-stack and two-stack approaches are both O(1)
  for every operation.

----------------------------------------------------------

COMPLEXITY
----------
Brute:
push/pop/top -> O(1)
getMin       -> O(n)
Space        -> O(n)

Two Stacks:
All ops      -> O(1)
Space        -> O(n)

Pair Stack:
All ops      -> O(1)
Space        -> O(n)

==========================================================
*/
}
