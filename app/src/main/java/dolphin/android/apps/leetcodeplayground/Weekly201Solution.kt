package dolphin.android.apps.leetcodeplayground

import kotlin.math.pow

/**
 * https://leetcode.com/contest/weekly-contest-201
 */
class Weekly201Solution {
    /**
     * https://leetcode.com/contest/weekly-contest-201/problems/make-the-string-great/
     */
    fun makeGood(s: String): String {
        if (s.length < 2) return s
        var updated = true
        var n: CharArray
        var r = s
        while (updated) {
            n = r.toCharArray()
            updated = false // init no changed
            for (i in 0 until n.size - 1) {
                if (n[i] == ' ') {
                    continue // compared
                } else if (n[i].isLetter().not()) {
                    return "" // should not be here
                } else if (n[i] != n[i + 1] && n[i].toLowerCase() == n[i + 1].toLowerCase()) {
                    n[i] = ' '
                    n[i + 1] = ' '
                    updated = true // mark we should check again
                    continue
                }
            }
            r = "" // reconstruct the string
            n.forEach { if (it.isLetter()) r += it }
        }
        return r
    }

    /**
     * https://leetcode.com/contest/weekly-contest-201/problems/find-kth-bit-in-nth-binary-string/
     */
    fun findKthBit(n: Int, k: Int): Char {
        if (k <= 1) return '0' // the very first
        return if (n > 4) { // simplify the set
            val half = 2.0.pow(n - 1).toInt() // find center one
            when {
                k == half -> '1' // center MUST be 1
                k > half -> findKthBit(n - 1, 2.0.pow(n).toInt() - k).invertBit() // reverse
                else -> findKthBit(n - 1, k) // find in smaller set
            }
        } else { // smaller set
            val ns = makeNthBinaryString(n)
            ns[k - 1] // zero-index based
        }
    }

    fun makeNthBinaryString(n: Int): String {
        if (n == 1) return "0"
        val ns = makeNthBinaryString(n - 1)
        var sn = ""
        ns.reversed().forEach {
            sn += it.invertBit()
        }
        return ns + "1" + sn
    }

    private fun Char.invertBit(): Char = when (this) {
        '1' -> '0'
        else -> '1'
    }
}