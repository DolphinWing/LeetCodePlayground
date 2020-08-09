package dolphin.android.apps.leetcodeplayground

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Weekly201Test {
    private lateinit var solution: Weekly201Solution

    @Before
    fun setup() {
        solution = Weekly201Solution()
    }

    @Test
    fun `Make The String Great 1`() {
        Assert.assertEquals("leetcode", solution.makeGood("leEeetcode"))
    }

    @Test
    fun `Make The String Great 2`() {
        Assert.assertEquals("", solution.makeGood("abBAcC"))
    }

    @Test
    fun `Make The String Great 3`() {
        Assert.assertEquals("s", solution.makeGood("s"))
    }

    @Test
    fun `Make The String Great 4`() {
        Assert.assertEquals("leetcode", solution.makeGood("lEeeetCccode"))
    }

    @Test
    fun `Nth Binary String 1`() {
        Assert.assertEquals("0", solution.makeNthBinaryString(1))
    }

    @Test
    fun `Nth Binary String 2`() {
        Assert.assertEquals("011", solution.makeNthBinaryString(2))
    }

    @Test
    fun `Nth Binary String 3`() {
        Assert.assertEquals("0111001", solution.makeNthBinaryString(3))
    }

    @Test
    fun `Nth Binary String 4`() {
        Assert.assertEquals("011100110110001", solution.makeNthBinaryString(4))
    }

    @Test
    fun `Find Kth Bit in Nth Binary String 1`() {
        Assert.assertEquals('0', solution.findKthBit(3, 1))
    }

    @Test
    fun `Find Kth Bit in Nth Binary String 2`() {
        Assert.assertEquals('1', solution.findKthBit(4, 11))
    }

    @Test
    fun `Find Kth Bit in Nth Binary String 3`() {
        Assert.assertEquals('0', solution.findKthBit(1, 1))
    }

    @Test
    fun `Find Kth Bit in Nth Binary String 4`() {
        Assert.assertEquals('1', solution.findKthBit(2, 3))
    }

    @Test
    fun `Find Kth Bit in Nth Binary String 5`() {
        Assert.assertEquals('1', solution.findKthBit(4, 7))
    }

    @Test
    fun `Find Kth Bit in Nth Binary String 6`() {
        Assert.assertEquals('1', solution.findKthBit(5, 16))
    }
}