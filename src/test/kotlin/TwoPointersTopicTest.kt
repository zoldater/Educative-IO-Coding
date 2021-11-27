import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class TwoPointersTopicTest {
    @Test
    fun pairWithTargetSum() {
        assertEquals(1 to 3, pairWithTargetSum(intArrayOf(1, 2, 3, 4, 6), 6))
        assertEquals(0 to 2, pairWithTargetSum(intArrayOf(2, 5, 9, 11), 11))
    }

    @Test
    fun removeDuplicates() {
        assertEquals(4, removeDuplicates(intArrayOf(2, 3, 3, 3, 6, 9, 9)))
        assertEquals(2, removeDuplicates(intArrayOf(2, 2, 2, 11)))
    }

    @Test
    fun tripletSumToZero() {
        val caseOne = intArrayOf(-3, 0, 1, 2, -1, 1, -2) to listOf(
            intArrayOf(-3, 1, 2),
            intArrayOf(-2, 0, 2),
            intArrayOf(-2, 1, 1),
            intArrayOf(-1, 0, 1)
        )
        val caseTwo = intArrayOf(-5, 2, -1, -2, 3) to listOf(
            intArrayOf(-5, 2, 3),
            intArrayOf(-2, -1, 3)
        )
        for ((case, answer) in listOf(caseOne, caseTwo)) {
            val result = tripletSumToZero(case)
            result.forEach { resArr ->
                assert(answer.any { it.contentEquals(resArr) })
            }
        }
    }

    @Test
    fun tripletSumCloseToTarget() {
        assertEquals(1, tripletSumCloseToTarget(intArrayOf(-2, 0, 1, 2), 2))
        assertEquals(0, tripletSumCloseToTarget(intArrayOf(-3, -1, 1, 2), 1))
        assertEquals(3, tripletSumCloseToTarget(intArrayOf(1, 0, 1, 1), 100))
    }
}