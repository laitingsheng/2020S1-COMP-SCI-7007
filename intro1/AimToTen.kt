class AimToTen {
    fun need(marks: IntArray): Int = (19 * marks.size - 2 * marks.sum()).coerceAtLeast(0)
}
