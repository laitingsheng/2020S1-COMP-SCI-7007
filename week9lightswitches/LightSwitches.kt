class LightSwitches {
    private val Long.msb: Long
        get() {
            var tmp = this or (this shr 1)
            tmp = tmp or (tmp shr 2)
            tmp = tmp or (tmp shr 4)
            tmp = tmp or (tmp shr 8)
            tmp = tmp or (tmp shr 16)
            tmp = tmp or (tmp shr 32)
            return (tmp + 1) shr 1
        }

    fun countPossibleConfigurations(switches: Array<String>): Long {
        val converted = LongArray(switches.size) { i ->
            switches[i].fold(0L) { acc, c -> (acc shl 1) + if (c == 'Y') 1L else 0L }
        }
        val n = converted.size
        var m = converted.fold(0L) { acc, it -> if (it > acc) it else acc }.msb
        var r = 0
        while (m > 0) {
            var found = false
            for (i in r until n) {
                val c = converted[i]
                if (c and m != 0L) {
                    if (i != r) {
                        converted[i] = converted[r]
                        converted[r] = c
                    }
                    found = true
                    break
                }
            }
            if (found) {
                val s = converted[r]
                for (i in ++r until n) {
                    val c = converted[i]
                    if (c and m != 0L)
                        converted[i] = c xor s
                }
            }
            m = m shr 1
        }
        return 1L shl r
    }
}
