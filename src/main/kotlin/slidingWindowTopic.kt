import kotlin.math.max

fun fruitsIntoBaskets(fruitTrees: CharArray): Int {
    return longestSubstringWithMaximumKDistinctCharacters(fruitTrees.joinToString(separator = ""), 2)
}

fun longestSubstringWithMaximumKDistinctCharacters(input: String, k: Int): Int {
    var left = 0
    var currentMaxWindow = 0
    val currentCharactersBag = mutableMapOf<Char, Int>()
    for ((index, char) in input.toCharArray().withIndex()) {
        currentCharactersBag[char] = (currentCharactersBag[char] ?: 0) + 1
        while (currentCharactersBag.keys.size > k) {
            val leftChar = input.get(left)
            val leftCharCount = currentCharactersBag.getValue(leftChar)
            if (leftCharCount == 1) {
                currentCharactersBag.remove(leftChar)
            } else {
                currentCharactersBag[leftChar] = leftCharCount - 1
            }
            left++
        }
        currentMaxWindow = max(currentMaxWindow, index - left + 1)
    }
    return currentMaxWindow
}

fun smallestSubarrayWithSum(array: IntArray, sum: Int): Int {
    var left = 0
    var currentSum = 0
    var minLength = Int.MAX_VALUE
    for ((right, value) in array.withIndex()) {
        currentSum += value
        while (left <= right) {
            if (currentSum >= sum) {
                minLength = minOf(minLength, right - left + 1)
                currentSum -= array[left]
                left++
            } else {
                break
            }
        }
    }
    return minLength
}

fun maxSumOfSubArrays(array: IntArray, k: Int): Int {
    var maxSum = 0
    var currentSum = 0
    for ((windowEnd, value) in array.withIndex()) {
        currentSum += value
        if (windowEnd >= k - 1) {
            maxSum = max(maxSum, currentSum)
            currentSum -= array[windowEnd - k + 1]
        }
    }
    return maxSum
}