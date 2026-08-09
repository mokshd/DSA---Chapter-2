package ArrayHashing;

public class GroupAnagrams {
    /*
==========================================================
Problem: 49. Group Anagrams
Pattern: Hashing | Sorting | Frequency Signature | Streams
==========================================================

INTUITION
---------
Anagrams have the same character frequency.
Create a common key/signature -> group by that key.

----------------------------------------------------------

APPROACH 1 - Brute Force
------------------------
Idea:
Compare every string with every other string and check
whether they are anagrams.

TC: O(n² * k log k)
SC: O(1) extra*

----------------------------------------------------------

APPROACH 2 - Sorting
--------------------
Idea:
Sort each string -> sorted string becomes the key.

Pseudo:
// for each string
//     char[] arr = string.toCharArray()
//     sort(arr)
//     key = new String(arr)
//     map[key].add(string)
// return map.values()

TC: O(n * k log k)
SC: O(n * k)

----------------------------------------------------------

APPROACH 3 - Frequency Count (Optimal)
--------------------------------------
Idea:
Count a-z frequency -> use frequency as key.

Pseudo:
// for each string
//     int[26] freq
//     count characters
//     build key from freq
//     map[key].add(string)
// return map.values()

TC: O(n * k)
SC: O(n * k)

----------------------------------------------------------

APPROACH 4 - Java 8 Streams
---------------------------
Idea:
Same sorting approach, expressed using Streams.

Pseudo:
// groupBy(
//     sorted characters of each string
// )

Code:

Map<String, List<String>> result =
    Arrays.stream(strs)
        .collect(Collectors.groupingBy(
            s -> s.chars()
                  .sorted()
                  .mapToObj(c -> String.valueOf((char) c))
                  .collect(Collectors.joining())
        ));

return new ArrayList<>(result.values());

TC: O(n * k log k)
SC: O(n * k)

NOTE:
• Good Java 8 Stream practice.
• Prefer normal loop in interviews for clarity.
• Frequency approach is better when avoiding sorting.

----------------------------------------------------------

KEY SIGNATURE
-------------
"eat" -> sorted -> "aet"
"tea" -> sorted -> "aet"
"ate" -> sorted -> "aet"

OR

"eat" -> frequency signature
"tea" -> same frequency signature
"ate" -> same frequency signature

=> Same key -> Same group

----------------------------------------------------------

FOLLOW-UPS
----------
• Lowercase a-z only? -> int[26]
• Unicode/arbitrary chars? -> HashMap<Character,Integer>
• Avoid sorting? -> Frequency count
• Already sorted strings? -> Sorting key is still O(k) to copy,
  frequency may be simpler depending on constraints.

----------------------------------------------------------

EDGE CASES
----------
• Empty strings
• Single-character strings
• Duplicate strings
• All strings are anagrams
• No anagrams
• Different string lengths

----------------------------------------------------------

REMEMBER
--------
• Anagram -> same character frequency.
• int[26] -> only lowercase a-z.
• Frequency signature avoids sorting.
• '#' delimiter makes frequency key unambiguous.
• computeIfAbsent() avoids manual containsKey().
• Streams can express the sorting solution compactly,
  but don't sacrifice readability in interviews.

----------------------------------------------------------

COMPLEXITY
----------
Brute Force : O(n² * k log k)
Sorting     : O(n * k log k)
Frequency   : O(n * k)
Streams     : O(n * k log k)

Space:
Map/output storage -> O(n * k)

==========================================================
*/
}
