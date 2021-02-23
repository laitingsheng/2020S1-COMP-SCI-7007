class SquareOfDigits {
    private val Int.square
        get() = this * this

    fun getMax(data: Array<String>): Int {
        val m = data.size
        val n = data[0].length
        for (l in (Math.min(m, n) - 1) downTo 1)
            for (i in 0 until m - l)
                for (j in 0 until n - l) {
                    val ni = i + l
                    val nj = j + l
                    if (data[i][j] == data[ni][nj] && data[i][nj] == data[ni][j] && data[i][j] == data[i][nj])
                        return (l + 1).square
                }
        return 1
    }
}
