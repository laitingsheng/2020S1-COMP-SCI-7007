class MakingChange {
    private val coins = IntArray(100) { it }

    init {
        for (i in 10 until 100)
            coins[i] = Math.min(coins[i], coins[i - 10] + 1)
        for (i in 25 until 100)
            coins[i] = Math.min(coins[i], coins[i - 25] + 1)
    }

    fun smallestChange(cost: Long): Int {
        var cc = cost
        var c = 0
        while (cc > 0) {
            c += coins[(cc % 100L).toInt()]
            cc /= 100L
        }
        return c
    }
}
