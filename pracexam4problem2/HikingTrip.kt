class HikingTrip {
    fun possible(n: Int, h0: Int, hn: Int, history: String): String {
        var c = h0
        var uc = 0
        history.forEach { h ->
            c += if (h == 'U') 1 else -1
            if (c < 0) {
                ++c
                ++uc
            }
        }
        val lc = n - uc - history.length
        val lh = Math.abs(hn - c)
        return if (lc < 0 || lh > lc || (lc - lh) % 2 != 0) "NO" else "YES"
    }
}
