package dolphin.android.apps.leetcodeplayground

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AcceptedTest {
    private lateinit var solution: AcceptedSolution

    @Before
    fun setup() {
        solution = AcceptedSolution()
    }

    @Test
    fun testTwoSum1() {
        val ans = solution.twoSum(intArrayOf(2, 7, 11, 15), 9)
        Assert.assertEquals(0, ans[0])
        Assert.assertEquals(1, ans[1])
    }

    @Test
    fun testTwoSum2() {
        val ans = solution.twoSum(intArrayOf(2, 7, 11, 15), 18)
        Assert.assertEquals(1, ans[0])
        Assert.assertEquals(2, ans[1])
    }

    @Test
    fun `Reverse Integer 123`() {
        Assert.assertEquals(321, solution.reverseInteger(123))
    }

    @Test
    fun `Reverse Integer -123`() {
        Assert.assertEquals(-321, solution.reverseInteger(-123))
    }

    @Test
    fun `Reverse Integer 120`() {
        Assert.assertEquals(21, solution.reverseInteger(120))
    }

    @Test
    fun `Roman to Integer - III`() {
        Assert.assertEquals(3, solution.romanToInt("III"))
    }

    @Test
    fun `Roman to Integer - IV`() {
        Assert.assertEquals(4, solution.romanToInt("IV"))
    }

    @Test
    fun `Roman to Integer - IX`() {
        Assert.assertEquals(9, solution.romanToInt("IX"))
    }

    @Test
    fun `Roman to Integer - LVIII`() {
        Assert.assertEquals(58, solution.romanToInt("LVIII"))
    }

    @Test
    fun `Roman to Integer - MCMXCIV`() {
        Assert.assertEquals(1994, solution.romanToInt("MCMXCIV"))
    }

    @Test
    fun `Longest Common Prefix 1`() {
        Assert.assertEquals("fl", solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    }

    @Test
    fun `Longest Common Prefix 2`() {
        Assert.assertEquals("", solution.longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    }

    @Test
    fun `Longest Common Prefix 3`() {
        Assert.assertEquals("", solution.longestCommonPrefix(arrayOf()))
    }

    @Test
    fun `Longest Common Prefix 4`() {
        Assert.assertEquals("red", solution.longestCommonPrefix(arrayOf("redsox", "reddit", "red")))
    }

    @Test
    fun `Check If Array Pairs Are Divisible by k - 1`() {
        Assert.assertEquals(true, solution.canArrange(intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9), 5))
    }

    @Test
    fun `Check If Array Pairs Are Divisible by k - 2`() {
        Assert.assertEquals(true, solution.canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 7))
    }

    @Test
    fun `Check If Array Pairs Are Divisible by k - 3`() {
        Assert.assertEquals(false, solution.canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 10))
    }

    @Test
    fun `Check If Array Pairs Are Divisible by k - 4`() {
        Assert.assertEquals(true, solution.canArrange(intArrayOf(-10, 10), 2))
    }

    @Test
    fun `Check If Array Pairs Are Divisible by k - 5`() {
        Assert.assertEquals(true, solution.canArrange(intArrayOf(-1, 1, -2, 2, -3, 3, -4, 4), 3))
    }

    @Test
    fun `tic tac toe case 1`() {
        // [[0,0],[2,0],[1,1],[2,1],[2,2]]
        Assert.assertEquals(
            "A", solution.tictactoe(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(2, 0),
                    intArrayOf(1, 1),
                    intArrayOf(2, 1),
                    intArrayOf(2, 2)
                )
            )
        )
    }

    @Test
    fun `tic tac toe case 2`() {
        // [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
        Assert.assertEquals(
            "B", solution.tictactoe(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 0),
                    intArrayOf(2, 0)
                )
            )
        )
    }

    @Test
    fun `tic tac toe case 3`() {
        // [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
        Assert.assertEquals(
            "Draw", solution.tictactoe(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(2, 0),
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(2, 2)
                )
            )
        )
    }

    @Test
    fun `tic tac toe case 4`() {
        // [[0,0],[1,1]]
        Assert.assertEquals(
            "Pending", solution.tictactoe(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1)
                )
            )
        )
    }
}