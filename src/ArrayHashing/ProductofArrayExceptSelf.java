package ArrayHashing;

public class ProductofArrayExceptSelf {
    /*
==========================================================
Problem: 238. Product of Array Except Self
Pattern: Prefix Product | Suffix Product
==========================================================

APPROACH 1 - Brute Force
------------------------
Idea:
For every index, multiply all elements except nums[i].

Pseudo:
// for i = 0 -> n-1
//     product = 1
//     for j = 0 -> n-1
//         if i != j
//             product *= nums[j]
//     result[i] = product

TC: O(n²)
SC: O(1) extra

----------------------------------------------------------

APPROACH 2 - Division
---------------------
Idea:
Calculate total product and divide by nums[i].

Pseudo:
// totalProduct = product of all nums
// result[i] = totalProduct / nums[i]

Problem:
❌ Fails with zero(s).
❌ Usually not allowed because problem asks without division.

TC: O(n)
SC: O(1)

Zero cases:
// 1 zero  -> result[zeroIndex] = product of non-zero elements
// 2+ zero -> all results = 0

----------------------------------------------------------

APPROACH 3 - Prefix + Suffix Arrays
-----------------------------------
Idea:
For each index:

result[i] =
product of elements LEFT
*
product of elements RIGHT

Pseudo:

// prefix[i] = product before i
// suffix[i] = product after i
//
// for i = 0 -> n-1
//     prefix[i] = pre
//     pre *= nums[i]
//
// for i = n-1 -> 0
//     suffix[i] = suf
//     suf *= nums[i]
//
// result[i] = prefix[i] * suffix[i]

TC: O(n)
SC: O(n)

----------------------------------------------------------

APPROACH 4 - Optimal: Output + Prefix Variable
----------------------------------------------
Idea:
Use result[] for prefix products and one variable for
suffix product. No separate prefix/suffix arrays.

Pseudo:

// result[i] = product of elements before i
// pre = 1
// for i = 0 -> n-1
//     result[i] = pre
//     pre *= nums[i]
//
// suf = 1
// for i = n-1 -> 0
//     result[i] *= suf
//     suf *= nums[i]
//
// return result

TC: O(n)
SC: O(1) extra
(Output array is not counted)

----------------------------------------------------------

FOLLOW-UPS
----------
• Can you use division? -> Yes, but zero makes it tricky
  and problem usually forbids division.
• Can you do O(1) extra space? -> Yes, use result as prefix.
• What if there are zeros? -> Prefix/suffix solution handles
  them automatically.
• Can you do it in one pass? -> Need information from both
  left and right, so practical solution uses two passes.

----------------------------------------------------------

EDGE CASES
----------
• Zero
• Multiple zeros
• Negative numbers
• Single element
• Large products / integer overflow

----------------------------------------------------------

REMEMBER
--------
• Prefix = everything BEFORE current index.
• Suffix = everything AFTER current index.
• Initialize prefix/suffix product with 1.
• No division required.
• Your prefix + suffix array solution = O(n) space.
• Reuse result[] to achieve O(1) EXTRA space.

Example:
nums = [1,2,3,4]

prefix:
[1,1,2,6]

suffix:
[24,12,4,1]

result:
[24,12,8,6]

==========================================================
*/
}
