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
        assertTrue(true)
        assertEquals(3 + 4, 4 + 3)
    }
}