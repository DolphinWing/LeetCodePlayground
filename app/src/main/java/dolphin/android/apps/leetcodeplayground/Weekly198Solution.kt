package dolphin.android.apps.leetcodeplayground

import kotlin.math.abs

/**
 * https://leetcode.com/contest/weekly-contest-198
 */
class Weekly198Solution {
    /**
     *
     * Given numBottles full water bottles, you can exchange numExchange empty water bottles for
     * one full water bottle.
     *
     * The operation of drinking a full water bottle turns it into an empty bottle.
     *
     * Return the maximum number of water bottles you can drink.
     *
     * 1 <= numBottles <= 100, 2 <= numExchange <= 100
     *
     * @param numBottles given full water bottles
     * @param numExchange empty water bottles for one full water bottle
     * @return the maximum number of water bottles you can drink
     */
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var result = 0
        var exchange: Int = numBottles // initial given
        var rest = 0
        while (exchange > 0) { // do when we can still exchange, stop when no new full bottles
            result += exchange // drinking all
            val bottles = exchange + rest // check empty bottles
            exchange = bottles / numExchange // exchange for full one
            rest = bottles % numExchange // remaining empty bottles
        }
        return result
    }

    /**
     * https://leetcode.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/submissions/
     *
     * Find a Value of a Mysterious Function Closest to Target
     *
     * Return the minimum possible value of |func(arr, l, r) - target|.
     *
     * 1 <= arr.length <= 10^5, 1 <= arr[ i ] <= 10^6, 0 <= target <= 10^7
     *
     * @param arr integer array for Winston's mysterious function
     * @param target an integer target for Winston's mysterious function
     * @return minimum possible value of |func(arr, l, r) - target|
     */
    fun closestToTarget(arr: IntArray, target: Int): Int {
        val dist = arr.distinct()
        if (dist.size == 1) { // all the same, only can return the same value
            return abs(dist.first() - target)
        } else if (target > 0) {
            val array = Array(dist.size) { i ->
                var ans = dist[i]
                val a = Array(dist.size - i) { j ->
                    ans = ans and dist[i + j]
                    abs(ans - target)
                }
                a.sortedArray().first()
            }
            return array.sortedArray().first()
        }
        return 0
    }
}