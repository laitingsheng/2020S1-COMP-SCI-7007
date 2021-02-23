class HandsShaking {
    private val Long.square: Long
        get() = this * this

    fun countPerfect(n: Int): Long {
        val half = n / 2
        val maps = LongArray(half + 1)
        maps[0] = 1
        for (i in 1 .. half) {
            val hi = i / 2
            var s = 0L
            for (j in 0 until hi)
                s += maps[j] * maps[i - j - 1]
            s *= 2
            if (i % 2 == 1)
                s += maps[hi].square
            maps[i] = s
        }
        return maps[half]
    }
}
