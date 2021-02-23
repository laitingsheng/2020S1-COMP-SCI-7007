class ToborWalk {
    fun getdist(T: Int, a: IntArray): Long {
        var x = 0L
        var y = 0L
        var d = 0
        a.forEach { i ->
            when (d) {
                0 -> y -= i
                1 -> x += i
                2 -> y += i
                3 -> x -= i
            }
            d = (d + i) % 4
        }
        return when (d) {
            0 -> (Math.abs(x) + Math.abs(y)) * T
            2 -> if (T % 2 == 0) 0 else Math.abs(x) + Math.abs(y)
            else -> when (T % 4) {
                0 -> 0
                2 -> {
                    x = Math.abs(x)
                    y = Math.abs(y)
                    x + y + Math.abs(x - y)
                }
                else -> Math.abs(x) + Math.abs(y)
            }
        }
    }
}
