package Stack;

public class ValidParentheses {
    /*
==========================================================
Problem: 20. Valid Parentheses
Pattern: Stack | LIFO
==========================================================

INTUITION
---------
For every opening bracket, expect its matching closing
bracket. Stack stores the expected closing bracket.

Example:
"({[" -> stack = [']', '}', ')']

----------------------------------------------------------

APPROACH 1 - Brute Force
------------------------
Idea:
Repeatedly remove matching pairs: (), {}, [].
If no more pairs can be removed, check if string is empty.

Pseudo:
// while string contains (), {}, or []
//     remove a matching pair
//
// return string is empty

TC: O(n²)
SC: O(n)

NOTE:
String modification/search can take O(n) repeatedly.

----------------------------------------------------------

APPROACH 2 - Stack
------------------
Idea:
Push expected closing bracket when opening bracket appears.
For a closing bracket, it must match stack top.

Pseudo:
// create stack
//
// for each char:
//     '(' -> push ')'
//     '[' -> push ']'
//     '{' -> push '}'
//
//     closing bracket:
//         if stack empty -> false
//         if c != stack.pop() -> false
//
// return stack.empty()

TC: O(n)
SC: O(n)

----------------------------------------------------------

IMPLEMENTATION
--------------
Preferred:
// Deque<Character> stack = new ArrayDeque<>();

Why?
• Deque is preferred over legacy Stack.
• ArrayDeque is fast and lightweight.
• push() / pop() -> O(1)

----------------------------------------------------------

FOLLOW-UPS
----------
• Why push closing bracket instead of opening bracket?
  -> Then closing char directly matches stack.pop().

• Why check stack.isEmpty()?
  -> Closing bracket without matching opening bracket.

• Why stack.empty() at the end?
  -> Unmatched opening brackets may remain.

• Can we solve without stack?
  -> Not generally; nested order requires LIFO.

----------------------------------------------------------

EDGE CASES
----------
• "" -> true
• "()" -> true
• "([{}])" -> true
• "(]" -> false
• "([)]" -> false
• ")" -> false
• "(" -> false

----------------------------------------------------------

REMEMBER
--------
• Parentheses matching -> think STACK.
• Nested structure -> LIFO.
• Push EXPECTED closing bracket.
• `ArrayDeque` preferred over `Stack`.
• `push()` + `pop()` -> O(1).
• Always check `isEmpty()` before `pop()`.

Java:
Deque<Character> stack = new ArrayDeque<>();

----------------------------------------------------------

COMPLEXITY
----------
Brute Force : O(n²)  O(n)
Stack       : O(n)   O(n)

==========================================================
*/
}

