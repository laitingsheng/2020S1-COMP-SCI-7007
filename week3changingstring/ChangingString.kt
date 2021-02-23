class ChangingString {
    fun distance(A: String, B: String, K: Int): Int {
        var n = 0
        val diffs = IntArray(A.length) {
            val diff = Math.abs(A[it] - B[it])
            if (diff > 0)
                ++n
            diff
        }
        diffs.sort()
        return if (n > K) {
            var s = 0
            for (i in A.length - n until A.length - K)
                s += diffs[i]
            s
        } else
            K - n
    }
}
