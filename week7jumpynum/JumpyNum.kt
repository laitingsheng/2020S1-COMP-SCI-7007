class JumpyNum {
    private val counts = Array(10) { IntArray(10) }

    init {
        counts[0].fill(1)
        counts.reduce { p, c ->
            for (i in 0..9) {
                for (j in 0 until i - 1)
                    c[i] += p[j]
                for (j in i + 2 until c.size)
                    c[i] += p[j]
            }
            c
        }
    }

    private fun howMany(num: Int): Int {
        var re = 0

        var p = 1
        var c = 0
        var tmp = num
        while (tmp >= 10) {
            val row = counts[c]
            for (j in 1..9)
                re += row[j]
            tmp /= 10
            p *= 10
            ++c
        }

        var prev = num / p
        var r = counts[c]
        for (i in 1 until prev)
            re += r[i]

        tmp = num % p
        while (tmp > 0) {
            p /= 10
            --c
            val curr = tmp / p
            r = counts[c]
            for (i in 0 until curr)
                if (Math.abs(prev - i) >= 2)
                    re += r[i]
            if (Math.abs(curr - prev) < 2)
                break
            tmp %= p
            prev = curr
        }

        return re
    }

    fun howMany(low: Int, high: Int): Int {
        return howMany(high + 1) - howMany(low)
    }
}
