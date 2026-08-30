package ArrayHashing;

public class ValidSudoku {
    /*
==========================================================
Problem: 36. Valid Sudoku
Pattern: HashSet | Matrix | Encoding
==========================================================

RULE
----
A digit cannot repeat in:
• Same row
• Same column
• Same 3x3 box

'.' -> ignore

----------------------------------------------------------

APPROACH 1 - Brute Force
------------------------
Idea:
Check rows, columns and 3x3 boxes separately.

Pseudo:
// check every row for duplicate
// check every column for duplicate
// check every 3x3 box for duplicate
// if duplicate -> false
// return true

TC: O(81) -> O(1) for fixed 9x9
SC: O(9)  -> O(1)

----------------------------------------------------------

APPROACH 2 - 3 HashSet Arrays
-----------------------------
Idea:
Maintain separate Sets for every row, column and box.
Check all 3 while traversing each cell.

Pseudo:
// row[9], col[9], box[9]
//
// for each cell:
//     if '.' -> continue
//     boxId = (r/3)*3 + c/3
//
//     if value exists in row/col/box -> false
//     add value to all 3
//
// return true

TC: O(81) -> O(1)
SC: O(81) -> O(1)

----------------------------------------------------------

APPROACH 3 - Boolean Array
--------------------------
Idea:
Since only digits 1-9 exist, use boolean instead of HashSet.

Pseudo:
// row[9][9], col[9][9], box[9][9]
//
// for each cell:
//     num = board[r][c] - '1'
//     boxId = (r/3)*3 + c/3
//
//     if row[r][num] || col[c][num] || box[boxId][num]
//         return false
//
//     mark all 3 as true
//
// return true

TC: O(81) -> O(1)
SC: O(81) -> O(1)

----------------------------------------------------------

APPROACH 4 - Single HashSet ⭐
------------------------------
Idea:
Encode each occurrence as:

value + row
value + column
value + box

If any encoded key already exists -> duplicate.

Example:
'5' at row 2 -> "5_ROW_2"
'5' at column 4 -> "5_COL_4"
'5' in box 1 -> "5_BOX_1"

Pseudo:
// HashSet<String> set
//
// for each cell:
//     if '.' -> continue
//
//     rowKey = value + row
//     colKey = value + col
//     boxKey = value + boxId
//
//     if any key exists -> false
//
//     add all 3 keys
//
// return true

TC: O(81) -> O(1)
SC: O(81) -> O(1)

----------------------------------------------------------

BOX ID
------
boxId = (row / 3) * 3 + (col / 3)

0 | 1 | 2
--+---+--
3 | 4 | 5
--+---+--
6 | 7 | 8

----------------------------------------------------------

FOLLOW-UPS
----------
• O(1) extra space? -> Fixed 9x9 board means all approaches
  are technically O(1).
• Can you avoid 3 separate Sets? -> Single encoded HashSet.
• Why boolean array? -> Values are only 1-9.
• Can this work for NxN Sudoku? -> Yes, adjust box size/index.

----------------------------------------------------------

EDGE CASES
----------
• Empty board -> true
• Duplicate in row -> false
• Duplicate in column -> false
• Duplicate in box -> false
• Same number in different row/column/box -> allowed
• '.' -> ignore

----------------------------------------------------------

REMEMBER
--------
• `boxId = (r/3)*3 + (c/3)`
• Single HashSet works by creating UNIQUE keys.
• Same value + same row => duplicate.
• Same value + same column => duplicate.
• Same value + same box => duplicate.
• `val + "_ROW_" + i` creates a row-specific key.
• Check BEFORE adding.

----------------------------------------------------------

COMPLEXITY
----------
Brute Force : O(81)  O(1)
3 HashSets  : O(81)  O(1)
Boolean     : O(81)  O(1)
1 HashSet   : O(81)  O(1)

For generalized NxN:
TC -> O(N²)
SC -> O(N²)

==========================================================
*/
}
