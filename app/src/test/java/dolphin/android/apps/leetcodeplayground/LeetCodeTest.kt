package dolphin.android.apps.leetcodeplayground

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
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
    fun `Merge Two Sorted Lists 1`() {
        val l1 = Solution.ListNode(1).apply {
            next = Solution.ListNode(2).apply {
                next = Solution.ListNode(4)
            }
        }
        val l2 = Solution.ListNode(1).apply {
            next = Solution.ListNode(3).apply {
                next = Solution.ListNode(4)
            }
        }
        val result = solution.mergeTwoLists(l1, l2)
        assertNotNull(result)
        assertEquals(1, result!!.`val`)
        assertNotNull(result.next)
        result.next!!.let { n1 ->
            assertEquals(1, n1.`val`)
            assertNotNull(n1.next)
            n1.next!!.let { n2 ->
                assertEquals(2, n2.`val`)
                assertNotNull(n2.next)
                n2.next!!.let { n3 ->
                    assertEquals(3, n3.`val`)
                    assertNotNull(n3.next)
                    n3.next!!.let { n4 ->
                        assertEquals(4, n4.`val`)
                        assertNotNull(n4.next)
                        n4.next!!.let { n5 ->
                            assertEquals(4, n5.`val`)
                            assertNull(n5.next)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun `Merge Two Sorted Lists 2`() {
        val l1 = Solution.ListNode(1).apply {
            next = Solution.ListNode(2).apply {
                next = Solution.ListNode(4)
            }
        }
        val result = solution.mergeTwoLists(l1, null)
        assertNotNull(result)
        assertEquals(1, result!!.`val`)
        assertNotNull(result.next)
        result.next!!.let { n1 ->
            assertEquals(2, n1.`val`)
            assertNotNull(n1.next)
            n1.next!!.let { n2 ->
                assertEquals(4, n2.`val`)
                assertNull(n2.next)
            }
        }
    }

    @Test
    fun `Merge Two Sorted Lists 3`() {
        val l2 = Solution.ListNode(1).apply {
            next = Solution.ListNode(3).apply {
                next = Solution.ListNode(4)
            }
        }
        val result = solution.mergeTwoLists(null, l2)
        assertNotNull(result)
        assertEquals(1, result!!.`val`)
        assertNotNull(result.next)
        result.next!!.let { n1 ->
            assertEquals(3, n1.`val`)
            assertNotNull(n1.next)
            n1.next!!.let { n2 ->
                assertEquals(4, n2.`val`)
                assertNull(n2.next)
            }
        }
    }

    @Test
    fun `Merge Two Sorted Lists 4`() {
        val result = solution.mergeTwoLists(null, null)
        assertNull(result)
    }
}