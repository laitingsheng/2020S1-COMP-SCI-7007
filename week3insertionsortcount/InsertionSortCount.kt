class InsertionSortCount {
    // the nth item is expected to move x times where x is the number of items smaller than current item from the
    // current position
    fun countMoves(A: IntArray): Int = A.foldIndexed(0) { index, acc, item ->
        var re = acc
        for (i in (index + 1) until A.size)
            if (item > A[i])
                ++re
        re
    }
}
