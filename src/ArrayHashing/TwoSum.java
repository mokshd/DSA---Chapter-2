package ArrayHashing;

public class TwoSum {
    /*
==========================================================
Problem: 1. Two Sum
Pattern: Hashing | Two Pointers (Sorted Array)
==========================================================

INTUITION
---------
Find the complement (target - current) while traversing.

----------------------------------------------------------

APPROACH 1 - Brute Force
------------------------
Idea:
Check every possible pair.

Pseudo:
// for i = 0 -> n-2
//     for j = i+1 -> n-1
//         if nums[i] + nums[j] == target
//             return [i,j]

TC: O(n²)
SC: O(1)

----------------------------------------------------------

APPROACH 2 - HashMap (Optimal)
------------------------------
Idea:
Store visited number with its index.
Before storing current number, check if complement already exists.

Pseudo:
// HashMap<value,index>
// for each num
//     complement = target - num
//     if map contains complement
//         return [map.get(complement), currentIndex]
//     map.put(num,currentIndex)

TC: O(n)
SC: O(n)

----------------------------------------------------------

APPROACH 3 - Sorting + Two Pointers
-----------------------------------
Idea:
Sort array and use two pointers.

Pseudo:
// sort array (keep original indices)
// left = 0, right = n-1
// move pointers based on sum

TC: O(n log n)
SC: O(1)*

NOTE:
• Doesn't work directly because original indices are required.
• Need value-index pair before sorting.

----------------------------------------------------------

FOLLOW-UPS
----------
• Constant extra space? -> Sorting + Two Pointers
• Original indices required? -> HashMap
• Array already sorted? -> Two Pointers (O(n), O(1))

EDGE CASES
----------
• Negative numbers
• Duplicate values
• Target = 0
• Exactly one valid answer (LeetCode guarantee)

REMEMBER
--------
• Check complement BEFORE map.put().
• HashMap stores <value, index>.
• Duplicate values overwrite previous index.
• Two Pointer works only on sorted data.
• Sorting loses original indices unless stored separately.
• get() returns null if key doesn't exist.

OPTIMIZATION
------------
Instead of:
    containsKey() + get()

Use:
    Integer idx = map.get(target - val);
    if (idx != null)
        return new int[]{idx, i};

(1 hash lookup instead of 2)

COMPLEXITY
----------
Brute Force : O(n²)      O(1)
HashMap     : O(n)       O(n)
Sort + 2Ptr : O(n log n) O(1)*

==========================================================

     */
}
