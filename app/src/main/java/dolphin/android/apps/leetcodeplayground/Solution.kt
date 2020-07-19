package dolphin.android.apps.leetcodeplayground

import android.util.Log
import kotlin.math.abs

class Solution : AcceptedSolution() {
    companion object {
        private const val TAG = "LeetCode"
    }

    override fun wip(): Boolean {
        Log.d(TAG, "Here's the work in progress codes")
        return true
    }

    /**
     * https://leetcode.com/contest/weekly-contest-198/problems/find-a-value-of-a-mysterious-function-closest-to-target/
     *
     * Time Limit Exceeded.
     */
    fun closestToTarget(arr: IntArray, target: Int): Int {
        val dist = arr.distinct()
        if (dist.size == 1) { // all the same, only can return the same value
            return abs(dist.first() - target)
        } else if (target > 0) {
            val array = Array(arr.size) { i ->
                var ans = arr[i]
                val a = Array(arr.size - i) { j ->
                    ans = ans and arr[i + j]
                    abs(ans - target)
                }
                a.sortedArray().first()
            }
            return array.sortedArray().first()
        }
        return 0
    }
}