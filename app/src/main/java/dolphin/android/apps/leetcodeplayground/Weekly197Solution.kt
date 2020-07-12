package dolphin.android.apps.leetcodeplayground

import android.util.Log
import kotlin.math.sqrt

/**
 * https://leetcode.com/contest/weekly-contest-197/
 *
 * I only passed [numIdenticalPairs]. others all failed.
 */
class Weekly197Solution {
    companion object {
        private const val TAG = "LeetCode"
    }

    fun wip(): Boolean {
        Log.d(TAG, "Here's the work in progress codes")
        return true
    }

    /**
     * https://leetcode.com/contest/weekly-contest-197/problems/number-of-good-pairs/
     *
     * Given an array of integers nums.
     * A pair (i,j) is called good if nums[ i ] == nums[ j ] and i < j.
     * Return the number of good pairs.
     *
     * @param nums an array of integers nums
     * @return an array of integers nums
     */
    fun numIdenticalPairs(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) result++
            }
        }
        return result
    }

    /**
     * https://leetcode.com/contest/weekly-contest-197/problems/number-of-substrings-with-only-1s/
     * Given a binary string s (a string consisting only of '0' and '1's).
     * Return the number of substrings with all characters 1's.
     * Since the answer may be too large, return it modulo 10^9 + 7.
     *
     * s[ i ] == '0' or s[ i ] == '1', 1 <= s.length <= 10^5
     *
     * @param s a binary string
     * @return the number of substrings
     */
    fun numSub(s: String): Int {
        var result = 0
        var p = 0
        val list = Array(20000) { 0 } // 1 <= s.length <= 10^5
        var i = 0
        s.forEach { c ->
            if (c == '0') {
                if (p > 0) {
                    list[i++] = p
                    p = 0
                } // else ignore them
            } else { // c == '1'
                p++
            }
        }
        if (p > 0) list[i] = p // for last continuous string
        list.forEach { c ->
            result += c * (c + 1) / 2
        }
        return result
    }

    /**
     * https://leetcode.com/contest/weekly-contest-197/problems/best-position-for-a-service-centre/
     *
     * Given an array positions where positions[ i ] = [xi, yi] is the position of the ith customer
     * on the map, return the minimum sum of the euclidean distances to all customers.
     *
     * Answers within 10^-5 of the actual value will be accepted.
     *
     * 1 <= positions.length <= 50
     * positions[ i ].length == 2
     * 0 <= positions[i][0], positions[i][1] <= 100
     */
    fun getMinDistSum(positions: Array<IntArray>): Double {
        if (positions.size == 1) return 0.0
        if (positions.size == 2) {
            return dist(positions[0], positions[1])
        }
        val x = IntArray(positions.size) { positions[it][0] }.apply { sort() }
        // Log.d(TAG, "x max=${x.last()} min=${x.first()}")
        val y = IntArray(positions.size) { positions[it][1] }.apply { sort() }
        // Log.d(TAG, "y max=${y.last()} min=${y.first()}")
        var min = 10000.0 // Double.MAX_VALUE
        var keyX = 0.0
        var keyY = 0.0
        for (i in x.first()..x.last()) {
            for (j in y.first()..y.last()) {
                val value =
                    distToAll(positions = positions, center = Pair(i.toDouble(), j.toDouble()))
                if (min > value) {
                    min = value
                    keyX = i.toDouble()
                    keyY = j.toDouble()
                }
            }
        }
        // Log.d(TAG, "min = $min around key = (${keyX}, $keyY)")
        var step = 1.0 / 2
        repeat(10) {
            var keyXX: Double = keyX
            var keyYY: Double = keyY
            for (i in intArrayOf(-1, 0, 1)) {
                val px = keyX + step * i
                for (j in intArrayOf(-1, 0, 1)) {
                    val py = keyY + step * j
                    val value = distToAll(positions = positions, center = Pair(px, py))
                    if (min > value) {
                        min = value
                        keyXX = px
                        keyYY = py
                    }
                }
            }
            Log.d(TAG, "key = (${keyXX}, $keyYY), min=$min")
            step /= 2
            keyX = keyXX
            keyY = keyYY
        }
        // Log.d(TAG, "key = (${keyXX}, $keyYY), min=$min")
        return min
    }

    private fun dist(p1: IntArray, p2: IntArray): Double {
        return dist(p1, arrayOf(p2[0].toDouble(), p2[1].toDouble()))
    }

    private fun dist(p1: IntArray, p2: Array<Double>): Double {
        val px = p1[0] - p2[0]
        val py = p1[1] - p2[1]
        return sqrt((px * px + py * py))
    }

    private fun distToAll(positions: Array<IntArray>, center: Pair<Double, Double>): Double {
        var result = 0.0
        positions.forEach { p ->
            result += dist(p, arrayOf(center.first, center.second))
        }
        return result
    }
}
