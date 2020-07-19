package dolphin.android.apps.leetcodeplayground

import java.util.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.set
import kotlin.math.abs
import kotlin.math.absoluteValue

open class AcceptedSolution {
    open fun wip(): Boolean = false

    /**
     * https://leetcode.com/problems/two-sum/
     *
     * Given an array of integers, return indices of the two numbers such that they add up to a
     * specific target. You may assume that each input would have exactly one solution, and you
     * may not use the same element twice.
     *
     * @param nums an array of integers
     * @param target target sum
     * @return indices of the two numbers
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, value ->
            map[value]?.let { left ->
                return intArrayOf(left, index)
            } ?: kotlin.run { map.put(target - value, index) }
        }
        return intArrayOf(-1, -1)
    }

    /**
     * https://leetcode.com/problems/reverse-integer/
     *
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Assume we are dealing with an environment which could only store integers within the 32-bit
     * signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your
     * function returns 0 when the reversed integer overflows.
     *
     * @param input 32-bit signed integer
     * @return reverse digits of an integer
     */
    fun reverseInteger(input: Int): Int {
        val str = input.absoluteValue.toString().reversed()
        return try {
            (if (input > 0) str else "-$str").toInt()
        } catch (e: Exception) {
            0
        }
    }

    private val romanMap = HashMap<Char, Int>()

    init {
        romanMap['I'] = 1
        romanMap['V'] = 5
        romanMap['X'] = 10
        romanMap['L'] = 50
        romanMap['C'] = 100
        romanMap['D'] = 500
        romanMap['M'] = 1000
    }

    /**
     * https://leetcode.com/problems/roman-to-integer/
     *
     * Given a roman numeral, convert it to an integer.
     *
     * @param s Input is guaranteed to be within the range from 1 to 3999
     * @return converted integer
     */
    fun romanToInt(s: String): Int {
        var result = 0
        // I can be placed before V (5) and X (10) to make 4 and 9.
        // X can be placed before L (50) and C (100) to make 40 and 90.
        // C can be placed before D (500) and M (1000) to make 400 and 900.
        var last = 0

        //I=1, V=5, X=10, L=50, C=100, D=500, M=1000
        s.reversed().forEach { c ->
            val now = romanMap[c] ?: 0
            result += if (now < last) -now else now
            last = now
        }
        return result
    }

    /**
     * https://leetcode.com/problems/longest-common-prefix/
     *
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     *
     * @param strs an array of strings
     * @return longest common prefix string. If there is no common prefix, it will be an empty string.
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        strs.sortBy { it.length }
        var result = strs.first()
        while (strs.any { it.startsWith(result).not() }) {
            result = result.dropLast(1)
        }
        return result
    }

    /**
     * https://leetcode.com/contest/weekly-contest-195/problems/check-if-array-pairs-are-divisible-by-k/
     *
     * Given an array of integers arr of even length n and an integer k. We want to divide the array
     * into exactly n / 2 pairs such that the sum of each pair is divisible by k.
     *
     * Constraints: arr.length == n, 1 <= n <= 10^5, and n is even.
     *              -10^9 <= arr[i] <= 10^9, 1 <= k <= 10^5
     *
     * @param arr an array of integers arr of even length
     * @param k integer
     * @return True If you can find a way to do that or False otherwise.
     */
    fun canArrange(arr: IntArray, k: Int): Boolean {
        if (arr.isEmpty() || arr.size % 2 != 0) return false
        val mod = Array(arr.size) {
            var c = (k - arr[it]) % k
            while (c < 0) c = (c + k) % k
            c
        }
        val counter = IntArray(k) { 0 }
        mod.forEach {
            counter[it] = counter[it] + 1
        }
        if (counter[0] % 2 == 0) {
            var result = true
            repeat(k) { key ->
                if (key != 0 && counter[key] != counter[k - key]) {
                    result = false
                }
            }
            return result
        }
        return false
    }

    /**
     * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
     *
     * Given an array moves where each element is another array of size 2 corresponding to the row
     * and column of the grid where they mark their respective character in the order in which A
     * and B play.
     *
     * Return the winner of the game if it exists (A or B), in case the game ends in a draw return
     * "Draw", if there are still movements to play return "Pending".
     *
     * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is
     * initially empty and A will play first.
     *
     * @param moves mark of moves in the order in which A and B play.
     * @return the winner of the game ("A" or "B"), "Draw" or "Pending"
     */
    fun tictactoe(moves: Array<IntArray>): String {
        val result = Array(9) { "" }
        moves.forEachIndexed { index, move ->
            result[move[0] * 3 + move[1]] = if (index % 2 == 0) "A" else "B"
        }
        if (result[0] == result[1] && result[1] == result[2] && result[2].isNotEmpty())
            return result[1] // A or B
        if (result[3] == result[4] && result[4] == result[5] && result[5].isNotEmpty())
            return result[4] // A or B
        if (result[6] == result[7] && result[7] == result[8] && result[8].isNotEmpty())
            return result[7] // A or B
        if (result[0] == result[3] && result[3] == result[6] && result[6].isNotEmpty())
            return result[3] // A or B
        if (result[1] == result[4] && result[4] == result[7] && result[7].isNotEmpty())
            return result[4] // A or B
        if (result[2] == result[5] && result[5] == result[8] && result[8].isNotEmpty())
            return result[5] // A or B
        if (result[0] == result[4] && result[4] == result[8] && result[8].isNotEmpty())
            return result[4] // A or B
        if (result[2] == result[4] && result[4] == result[6] && result[6].isNotEmpty())
            return result[4] // A or B
        return if (result.any { it.isEmpty() }) "Pending" else "Draw"
    }

    /**
     * https://leetcode.com/problems/valid-parentheses/
     *
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if
     * the input string is valid.
     *
     * An input string is valid if:
     * * Open brackets must be closed by the same type of brackets.
     * * Open brackets must be closed in the correct order.
     *
     * @param s input string
     * @return true if the input string is valid
     */
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false // impossible to be pair
        val stack = ArrayDeque<Char>()
        s.forEach { c ->
            when (c) {
                '(', '[', '{' -> stack.push(c)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            }
        }
        return stack.isEmpty() // not pair clean
    }

    /**
     * https://leetcode.com/contest/weekly-contest-198/problems/find-a-value-of-a-mysterious-function-closest-to-target/
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