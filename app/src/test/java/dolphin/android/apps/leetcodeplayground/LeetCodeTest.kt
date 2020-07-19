package dolphin.android.apps.leetcodeplayground

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

// @Config(sdk = [Build.VERSION_CODES.P])
// @RunWith(AndroidJUnit4::class)
class LeetCodeTest {
    private lateinit var solution: Solution

    @Before
    fun setup() {
        solution = Solution()
    }

    @Test
    fun wip() {
        assertTrue(solution.wip())
        assertEquals(3 + 4, 4 + 3)
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 1`() {
        assertEquals(2, solution.closestToTarget(intArrayOf(9, 12, 3, 7, 15), 5))
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 2`() {
        assertEquals(999999, solution.closestToTarget(intArrayOf(1000000, 1000000, 1000000), 1))
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 3`() {
        assertEquals(0, solution.closestToTarget(intArrayOf(1, 2, 4, 8, 16), 0))
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 4`() {
        assertEquals(9000000, solution.closestToTarget(intArrayOf(1000000, 999999, 1), 10000000))
    }

    @Test
    fun `Find a Value of a Mysterious Function Closest to Target 5`() {
        assertEquals(0, solution.closestToTarget(intArrayOf(70, 15, 21, 96), 4))
    }
}