package dolphin.android.apps.leetcodeplayground

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Weekly198Test {
    private lateinit var solution: Weekly198Solution

    @Before
    fun setup() {
        solution = Weekly198Solution()
    }

    @Test
    fun `Water Bottles 1`() {
        Assert.assertEquals(13, solution.numWaterBottles(9, 3))
    }

    @Test
    fun `Water Bottles 2`() {
        Assert.assertEquals(19, solution.numWaterBottles(15, 4))
    }

    @Test
    fun `Water Bottles 3`() {
        Assert.assertEquals(6, solution.numWaterBottles(5, 5))
    }

    @Test
    fun `Water Bottles 4`() {
        Assert.assertEquals(2, solution.numWaterBottles(2, 3))
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 1`() {
        Assert.assertEquals(2, solution.closestToTarget(intArrayOf(9, 12, 3, 7, 15), 5))
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 2`() {
        Assert.assertEquals(
            999999,
            solution.closestToTarget(intArrayOf(1000000, 1000000, 1000000), 1)
        )
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 3`() {
        Assert.assertEquals(0, solution.closestToTarget(intArrayOf(1, 2, 4, 8, 16), 0))
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 4`() {
        Assert.assertEquals(
            9000000,
            solution.closestToTarget(intArrayOf(1000000, 999999, 1), 10000000)
        )
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 5`() {
        Assert.assertEquals(0, solution.closestToTarget(intArrayOf(70, 15, 21, 96), 4))
    }
}