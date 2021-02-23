class PouringWater {
    fun getMinBottles(N: Int, K: Int): Int {
        var c = 0
        while (Integer.bitCount(N + c) > K)
            ++c
        return c
    }
}
