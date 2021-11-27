import kotlin.math.absoluteValue

data class Result(val triplet: IntArray, val distance: Int)

fun tripletSumCloseToTarget(array: IntArray, target: Int): Int {
    val sortedArray = array.sortedArray()
    return (0..(array.size - 2)).flatMap { findPairRightHand(it, sortedArray, target) }
        .minByOrNull { it.distance }!!
        .triplet
        .sumOf { it }
}

private fun findPairRightHand(left: Int, array: IntArray, targetSum: Int): Collection<Result> {
    val results = mutableListOf<Result>()
    var center = left + 1
    var right = array.size - 1
    while (center < right) {
        val curSum = array[left] + array[center] + array[right]
        val result = Result(intArrayOf(array[left], array[center], array[right]), (curSum - targetSum).absoluteValue)
        results.add(result)
        if (curSum > targetSum) right--
        if (curSum < targetSum) center++
        else {
            right--
            center++
        }
    }
    return results
}

fun tripletSumToZero(array: IntArray): Collection<IntArray> {
    val sortedArray = array.sortedArray()
    return (0..(array.size - 2)).flatMap { findPairRightHand(it, sortedArray, 0) }
        .filter { it.distance == 0 }
        .map { it.triplet }
}

fun removeDuplicates(intArray: IntArray): Int {
    var uniqueCount = 0
    var left = 0
    var right = 0
    while (left < intArray.size) {
        uniqueCount++
        while (right < intArray.size && intArray[left] == intArray[right]) {
            right++
        }
        left = right
    }
    return uniqueCount
}

fun pairWithTargetSum(array: IntArray, targetSum: Int): Pair<Int, Int> {
    var left = 0
    var right = array.size - 1
    while (left < right) {
        val curSum = array[left] + array[right]
        if (curSum > targetSum) right--
        else if (curSum < targetSum) left++
        else break
    }
    return left to right
}