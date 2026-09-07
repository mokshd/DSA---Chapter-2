package Stack;

public class CarFleet {
    /*
==========================================================
Problem: Car Fleet (LeetCode 853)
Pattern: Sorting + Greedy
==========================================================

INTUITION
---------
Cars move toward the same target.

Key idea:
- Sort cars by position from CLOSEST -> FARTHEST from target.
- Calculate each car's time to reach target.
- Process from front to back.

If a car behind takes <= time of the fleet ahead:
    -> it catches that fleet before/equal to target
    -> becomes the same fleet.

If its time > previous fleet time:
    -> it cannot catch the fleet ahead
    -> starts a NEW fleet.

Example:
Position: [10, 8, 0, 5, 3]
Speed:    [2, 4, 1, 1, 3]

After sorting by position descending:
10, 8, 5, 3, 0

Times:
10 -> 1
8  -> 1.5
5  -> 7
3  -> 7
0  -> 12

Fleet formation:
1       -> new fleet
1.5     -> new fleet
7       -> new fleet
7       -> joins previous fleet
12      -> new fleet

Answer = 4


----------------------------------------------------------
APPROACH 1 - Brute Force
----------------------------------------------------------

Idea:
For every car, simulate its movement and determine whether
it catches the car/fleet ahead.

Problem:
Simulation can require many time steps and handling
collisions becomes complicated.

TC: O(n²) or worse depending on simulation
SC: O(n)

Not recommended for interview.


----------------------------------------------------------
APPROACH 2 - Optimal: Sort + Greedy
----------------------------------------------------------

Idea:
1. Pair position + speed.
2. Sort by position descending.
3. Calculate time to target.
4. Maintain the time of the fleet directly ahead.
5. If currentTime > prevTime:
      current car cannot catch ahead fleet
      => new fleet.
6. Otherwise:
      current car catches/join the fleet.

Pseudo:

// create (position, speed) pairs
// sort cars by position descending
//
// fleet = 0
// prevTime = 0
//
// for each car:
//     currentTime = (target - position) / speed
//
//     if currentTime > prevTime:
//         fleet++
//         prevTime = currentTime
//
// return fleet


TC: O(n log n)
SC: O(n)

----------------------------------------------------------
APPROACH 3 - Stack
----------------------------------------------------------

Same sorting + time calculation.

Use a stack to store fleet arrival times.

For every car:
// time = (target - position) / speed
//
// if stack is empty OR time > stack.peek():
//     push time
//     new fleet
// else:
//     car joins existing fleet
//
// return stack.size()

TC: O(n log n)
SC: O(n)


IMPORTANT:
The stack is NOT actually necessary.

Only the largest/latest fleet time matters because cars
are processed from front -> back.

Therefore:

double prevTime

is enough.

Your APPROACH 2 is cleaner than APPROACH 3.


----------------------------------------------------------
WHY DOES <= MEAN SAME FLEET?
----------------------------------------------------------

Suppose:

Front car reaches target in 5 sec.
Behind car reaches target in 4 sec.

Behind car is faster in terms of arrival time.

But it cannot pass the front car.

Therefore it catches the front car BEFORE target
and both reach target as one fleet.

So:

currentTime <= prevTime
        ↓
same fleet

currentTime > prevTime
        ↓
new fleet


----------------------------------------------------------
YOUR BEST VERSION
----------------------------------------------------------

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars,
            (a, b) -> Integer.compare(b[0], a[0]));

        int fleet = 0;
        double prevTime = 0;

        for (int[] car : cars) {

            double currentTime =
                (double)(target - car[0]) / car[1];

            if (currentTime > prevTime) {
                fleet++;
                prevTime = currentTime;
            }
        }

        return fleet;
    }
}


----------------------------------------------------------
FOLLOW-UPS
----------------------------------------------------------

• Why sort by position descending?
  -> We need to process cars from closest to target
     to farthest.

• Why not sort by time?
  -> Fleet formation depends on spatial order.

• Why use double?
  -> Time can be fractional.

• Can we use float?
  -> Technically yes, but double is preferred for precision.

• Can we avoid O(n) auxiliary space?
  -> Not meaningfully with the standard comparison-sorting approach.

  We need to store the cars so we can sort/process them.

  A position-indexed array can avoid sorting if target/position
  range is small, but uses O(target) space and is generally
  not preferable.

  Standard solution:
  Time  = O(n log n)
  Space = O(n)

• Why can't a faster car pass the car ahead?
  -> Cars cannot pass each other, so it joins the fleet.


----------------------------------------------------------
EDGE CASES
----------------------------------------------------------

• n = 0 -> answer 0
• n = 1 -> answer 1
• Same arrival time -> same fleet
• Very fast car behind slow car -> catches it
• Car already near target -> likely forms its own fleet
• Positions are unique as guaranteed by the problem


----------------------------------------------------------
REMEMBER
----------------------------------------------------------

• Car Fleet = SORT + GREEDY.
• Sort positions DESCENDING.
• Calculate time to target.
• Keep only previous fleet's time.
• currentTime > prevTime -> NEW fleet.
• currentTime <= prevTime -> JOIN existing fleet.
• No need for an actual stack.
• Use `(double)` before division to avoid integer division.

Java pitfall:

double time = (target - position) / speed;  // WRONG

Because both operands are int -> integer division first.

double time = (double)(target - position) / speed; // CORRECT


----------------------------------------------------------
COMPLEXITY
----------------------------------------------------------

Brute Force : O(n²) or worse
Better       : -
Optimal      : O(n log n)

Optimal Space: O(n)

Main cost = sorting.


==========================================================
*/
}
