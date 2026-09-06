package Stack;

public class EvaluateReversePolishNotation {
    /*
==========================================================
Problem: 150. Evaluate Reverse Polish Notation
Pattern: Stack | Expression Evaluation
==========================================================

INTUITION
---------
Numbers -> push to stack.
Operator -> pop 2 operands, calculate, push result.

IMPORTANT:
For `-` and `/`:
    b = first pop
    a = second pop
    result = a operator b

----------------------------------------------------------

APPROACH 1 - Brute Force
------------------------
Idea:
Find an operator, calculate the previous two operands,
replace them with the result. Repeat.

Pseudo:
// while operators remain:
//     find operator
//     take previous 2 numbers
//     calculate
//     replace with result

TC: O(n²)
SC: O(n)

Problem:
Repeated searching/replacement makes it inefficient.

----------------------------------------------------------

APPROACH 2 - Stack (Optimal)
----------------------------
Idea:
Process tokens left-to-right.

Pseudo:
// create stack
//
// for each token:
//     if number -> push
//
//     else:
//         b = pop()
//         a = pop()
//         result = a operator b
//         push(result)
//
// return pop()

TC: O(n)
SC: O(n)

----------------------------------------------------------

OPERATOR ORDER
--------------
For:
    ["4", "2", "-"]

Stack:
4 -> [4]
2 -> [4,2]

operator '-':
b = 2
a = 4

a - b = 2

NEVER:
b - a ❌

Same for division.

----------------------------------------------------------

FOLLOW-UPS
----------
• Why Deque instead of Stack?
  -> `ArrayDeque` is preferred over legacy `Stack`.

• Negative numbers?
  -> `Integer.parseInt()` handles them.

• Division?
  -> Java integer division truncates toward zero.

• Why no parentheses?
  -> RPN already defines evaluation order.

----------------------------------------------------------

EDGE CASES
----------
• Single number -> return it
• Negative numbers
• Subtraction
• Division
• Intermediate negative result

----------------------------------------------------------

REMEMBER
--------
• RPN -> think STACK.
• Number -> push.
• Operator -> pop B, then A.
• Calculate A op B.
• Push result back.
• Java String comparison -> `.equals()`, not `==`.
• `Integer.parseInt()` -> String → int.

----------------------------------------------------------

COMPLEXITY
----------
Brute Force : O(n²)  O(n)
Stack       : O(n)   O(n)

==========================================================
*/
}
