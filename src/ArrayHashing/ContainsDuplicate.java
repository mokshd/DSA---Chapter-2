package ArrayHashing;

public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    /*
    ==========================================================
    Problem: 217. Contains Duplicate
    Pattern: Hashing | Sorting
    ==========================================================

    APPROACH 1 - Brute Force
    ------------------------
    Idea:
    Compare every element with remaining elements.

    Pseudo:
    for i = 0 -> n-1
        for j = i+1 -> n-1
            if nums[i] == nums[j]
                return true
    return false

    TC: O(n²)
    SC: O(1)

    ----------------------------------------------------------

    APPROACH 2 - Sorting
    --------------------
    Idea:
    Sort -> compare adjacent elements.

    Pseudo:
    sort(nums)
    for i = 0 -> n-2
        if nums[i] == nums[i+1]
            return true
    return false

    TC: O(n log n)
    SC: O(1)*

    ----------------------------------------------------------

    APPROACH 3 - HashSet (Optimal)
    ------------------------------
    Idea:
    Store visited elements.

    Pseudo:
    create HashSet
    for each num
        if add(num) == false
            return true
    return false

    TC: O(n)
    SC: O(n)

    ----------------------------------------------------------

    Follow-ups
    ----------
    • Constant extra space? -> Sorting
    • Can't modify array? -> HashSet
    • HashSet lookup -> O(1) avg, O(n) worst

    Edge Cases
    ----------
    • Empty array
    • Single element
    • Negative values
    • Large input

    Remember
    --------
    • HashSet.add(x) returns false if x already exists.
    • No need: contains() + add().
    • Sorting modifies original array.
    • Compare adjacent elements only.
    • Loop till n-2 (i < nums.length - 1).

    Complexity
    ----------
    Brute     : O(n²)      O(1)
    Sorting   : O(n log n) O(1)*
    HashSet   : O(n)       O(n)

    ==========================================================
    */

    // Solution...
}