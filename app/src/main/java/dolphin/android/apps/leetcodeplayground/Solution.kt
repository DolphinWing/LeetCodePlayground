package dolphin.android.apps.leetcodeplayground

import android.util.Log

class Solution : AcceptedSolution() {
    companion object {
        private const val TAG = "LeetCode"
    }

    override fun wip(): Boolean {
        Log.d(TAG, "Here's the work in progress codes")
        return true
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        val list = ArrayList<ListNode>()
        var next: ListNode? = l1
        while (next != null) { // add l1 to a list for sorting
            list.add(next)
            next = next.next
        }
        next = l2 // add all l2 to a list for sorting
        while (next != null) {
            list.add(next)
            next = next.next
        }
        list.sortBy { it.`val` } // sort by index
        return if (list.isNotEmpty()) {
            list.last().next = null // mark last has no next
            for (i in 0 until list.lastIndex) {
                list[i].next = list[i + 1]
            }
            list.first() // return the first one
        } else null // no list
    }
}