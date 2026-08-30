package ArrayHashing;

public class EncodeandDecodeStrings {
    /*
==========================================================
Problem: Encode and Decode Strings
Pattern: String Encoding | Parsing
==========================================================

APPROACH 1 - Brute Force: Delimiter
-----------------------------------
Idea:
Join strings using a delimiter and split during decode.

Pseudo:
// encode:
// result = ""
// for each string
//     result += string + "#"
//
// decode:
// split by "#"

TC: O(n)
SC: O(n)

Problem:
❌ Fails if '#' exists inside the original string.

Example:
["ab#c", "xyz"]
-> "ab#c#xyz"
Cannot identify original boundaries.

----------------------------------------------------------

APPROACH 2 - Better: Escape Delimiter
-------------------------------------
Idea:
Use '#' as delimiter but escape '#' when it appears
inside the string.

Pseudo:
// encode:
// replace "#" with "##"
// append "#"
//
// decode:
// "##" -> "#"
// single "#" -> delimiter

TC: O(n)
SC: O(n)

Problem:
More complicated parsing and escaping rules.
Need to handle escape sequences correctly.

----------------------------------------------------------

APPROACH 3 - Optimal: Length Prefix
-----------------------------------
Idea:
Store length before every string.

Format:
[length]#[string]

Example:
["ab#c", "xyz"]
-> "4#ab#c3#xyz"

Pseudo:

// ENCODE
// for each string
//     append length
//     append '#'
//     append string

// DECODE
// find '#'
// wordLen = parse length
// start = after '#'
// read exactly wordLen characters
// repeat

TC:
Encode -> O(n)
Decode -> O(n)

SC:
O(n)  // encoded string / output

----------------------------------------------------------

WHY LENGTH PREFIX IS BEST
-------------------------
• Delimiter can exist inside the string -> no problem.
• No escaping required.
• Simple and deterministic decoding.
• Works with empty strings -> "0#".

----------------------------------------------------------

FOLLOW-UPS
----------
• String contains '#' ? -> Length prefix handles it.
• Empty string? -> "0#"
• Multiple '#' ? -> No issue.
• Spaces/special characters? -> No issue.
• Why not split("#")? -> '#' can be part of data.

----------------------------------------------------------

EDGE CASES
----------
• Empty list
• Empty strings
• "#"
• "##abc##"
• Spaces / special characters

----------------------------------------------------------

REMEMBER
--------
• Never rely only on a delimiter if delimiter can be data.
• Length tells decoder exactly how many chars to read.
• substring(start, end) -> end is EXCLUSIVE.
• `wordLen` is parsed before moving to the actual word.

==========================================================
*/
}
