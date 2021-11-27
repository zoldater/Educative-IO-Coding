import org.junit.Test
import kotlin.test.assertEquals

class SlidingWindowTopicTest {

    @Test
    fun maxSumOfSubArrays() {
        assertEquals(9, maxSumOfSubArrays(intArrayOf(2, 1, 5, 1, 3, 2), 3))
        assertEquals(7, maxSumOfSubArrays(intArrayOf(2, 3, 4, 1, 5), 2))
    }

    @Test
    fun smallestSubarrayWithSum() {
        assertEquals(2, smallestSubarrayWithSum(intArrayOf(2, 1, 5, 2, 3, 2), 7))
        assertEquals(1, smallestSubarrayWithSum(intArrayOf(2, 1, 5, 2, 8), 7))
        assertEquals(3, smallestSubarrayWithSum(intArrayOf(3, 4, 1, 1, 6), 8))
    }

    @Test
    fun longestSubstringWithMaximumKDistinctCharacters() {
        assertEquals(4, longestSubstringWithMaximumKDistinctCharacters("araaci", 2))
        assertEquals(2, longestSubstringWithMaximumKDistinctCharacters("araaci", 1))
        assertEquals(5, longestSubstringWithMaximumKDistinctCharacters("cbbebi", 3))
        assertEquals(6, longestSubstringWithMaximumKDistinctCharacters("cbbebi", 10))
    }

    @Test
    fun fruitsIntoBaskets() {
        assertEquals(3, fruitsIntoBaskets(charArrayOf('A', 'B', 'C', 'A', 'C')))
        assertEquals(5, fruitsIntoBaskets(charArrayOf('A', 'B', 'C', 'B', 'B', 'C')))
    }
}