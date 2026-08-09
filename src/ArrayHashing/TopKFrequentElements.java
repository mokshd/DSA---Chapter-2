package ArrayHashing;

public class TopKFrequentElements {
    /*
==========================================================
Problem: 347. Top K Frequent Elements
Pattern: HashMap | Heap | Bucket Sort
==========================================================

INTUITION
---------
1. Count frequency of each number.
2. Find K numbers with highest frequency.

----------------------------------------------------------

APPROACH 1 - Brute Force
------------------------
Idea:
// Count frequency using HashMap
// For every possible frequency:
//     find numbers having that frequency
//     add until k elements

TC: O(n²)
SC: O(n)

----------------------------------------------------------

APPROACH 2 - Sorting
--------------------
Idea:
Count frequencies -> sort unique elements by frequency.

Pseudo:
// frequency map
// create list of unique numbers
// sort by frequency descending
// return first k

TC: O(n + m log m)
SC: O(m)

m = number of unique elements

----------------------------------------------------------

APPROACH 3 - Min Heap
---------------------
Idea:
Maintain only K most frequent elements in a Min Heap.

Pseudo:
// frequency map
// minHeap based on frequency
// for each number in map:
//     add number
//     if heap.size > k:
//         poll smallest frequency
// poll remaining k elements

TC: O(n + m log k)
SC: O(m + k)

m = unique elements

WHY MIN HEAP?
-------------
We only need K largest frequencies.

Keep the smallest among current K at the top.
When a better element comes -> remove it.

----------------------------------------------------------

APPROACH 4 - Bucket Sort (Optimal)
----------------------------------
Idea:
Frequency can be at most n.

Create bucket where:
index = frequency
value = numbers having that frequency.

Pseudo:
// frequency map
// List<Integer>[] bucket = new List[n + 1]
//
// for each number:
//     freq = map.get(number)
//     bucket[freq].add(number)
//
// iterate frequency from n -> 1
//     add numbers until k elements

TC: O(n)
SC: O(n)

----------------------------------------------------------

FOLLOW-UPS
----------
• Need exactly K elements? -> Heap / Bucket
• K = number of unique elements? -> Return all
• Streaming input? -> Min Heap
• K is very small? -> Min Heap O(n log k)
• Need strict O(n)? -> Bucket Sort
• Frequencies tied? -> Any order unless specified

----------------------------------------------------------

EDGE CASES
----------
• k = 1
• k = number of unique elements
• Duplicate values
• Negative numbers
• All elements same
• Every element occurs once

----------------------------------------------------------

REMEMBER
--------
• HashMap -> frequency counting.
• Min Heap -> keep only K largest.
• Bucket index = frequency.
• Maximum frequency = nums.length.
• Bucket Sort gives O(n) overall.
• Heap solution is usually easiest to explain in interviews.

IMPORTANT:
Avoid comparator subtraction:

(a,b) -> map.get(a) - map.get(b)   // possible overflow

Prefer:

(a,b) -> Integer.compare(map.get(a), map.get(b))

----------------------------------------------------------

HEAP TRICK
----------
Don't put all elements and then remove K.

Instead:
// add each element
// if size > k -> remove min

=> Heap never grows beyond K + 1.

----------------------------------------------------------

COMPLEXITY
----------
Brute Force : O(n²)          O(n)
Sorting     : O(n + m log m) O(m)
Min Heap    : O(n + m log k) O(m + k)
Bucket Sort : O(n)           O(n)

==========================================================
*/
}
