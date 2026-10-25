package SlidingWindow;

public class BestTimetoBuyandSellStock {

/*
==========================================================
Problem: Best Time to Buy and Sell Stock (LC 121)
Pattern: Greedy | Running Minimum
Alternative: Kadane's Algorithm
==========================================================

INTUITION
---------
Buy on one day and sell on a later day.

Profit = selling price - buying price

Track the minimum price seen so far. For every day,
calculate the profit if we sell on that day.

----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
// maxProfit = 0
// for buy = 0 to n-2:
//     for sell = buy+1 to n-1:
//         profit = prices[sell] - prices[buy]
//         maxProfit = max(maxProfit, profit)
// return maxProfit

TC: O(n^2)
SC: O(1)


----------------------------------------------------------
APPROACH 2 - Two Pointers
----------------------------------------------------------

Idea:
i = index of the lowest price seen so far
j = current selling day

// i = 0, j = 1, profit = 0
// while j < n:
//     if prices[j] < prices[i]:
//         i = j
//     else:
//         profit = max(profit, prices[j] - prices[i])
//     j++
// return profit

TC: O(n)
SC: O(1)

Your Solution 2 is correct.


----------------------------------------------------------
APPROACH 3 - Optimal: Running Minimum
----------------------------------------------------------

Idea:
Track the minimum buying price and best profit so far.

Pseudo:
// minPrice = infinity
// maxProfit = 0
// for price in prices:
//     minPrice = min(minPrice, price)
//     maxProfit = max(maxProfit, price - minPrice)
// return maxProfit

TC: O(n)
SC: O(1)

BEST INTERVIEW IMPLEMENTATION:

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}


----------------------------------------------------------
APPROACH 4 - Kadane's Algorithm
----------------------------------------------------------

Idea:
Convert prices into daily changes.

change[i] = prices[i] - prices[i-1]

The maximum profit equals the maximum subarray sum
of these changes, with 0 as the minimum allowed result.

Pseudo:
// current = 0, best = 0
// for i = 1 to n-1:
//     change = prices[i] - prices[i-1]
//     current = max(0, current + change)
//     best = max(best, current)
// return best

TC: O(n)
SC: O(1)

Your Solution 4 is correct.

----------------------------------------------------------
WHY APPROACH 3 WORKS
----------------------------------------------------------

For every selling price:
1. The minimum price seen so far is the best possible
   buying price before or on this day.
2. Calculate today's possible profit.
3. Update the maximum profit.

The algorithm never needs to store earlier prices
because the minimum price summarizes the useful history.

----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• Prices only decrease?
  Return 0; no profitable transaction exists.

• Why initialize maxProfit to 0?
  The problem allows choosing no transaction.

• Why must buying happen before selling?
  The minimum price is tracked while scanning left to right.

• Multiple transactions allowed?
  Different problem (LC 122); sum all positive daily changes.

• Need the actual buy/sell days?
  Track the index whenever minPrice changes and save the
  buy/sell indices whenever a new best profit is found.

----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• [] or [5] -> 0
• [7, 6, 4, 3, 1] -> 0
• [1, 2, 3, 4, 5] -> 4
• [7, 1, 5, 3, 6, 4] -> 5
• [2, 4] -> 2

----------------------------------------------------------
REMEMBER
----------------------------------------------------------

• LC 121: one transaction only.
• Running minimum + current profit is the simplest answer.
• Update minPrice before calculating today's profit;
  buying and selling on the same day yields 0 anyway.
• Solution 2 and Solution 3 are conceptually equivalent.
• Solution 4 is Kadane's algorithm on daily differences.

==========================================================
*/

}
