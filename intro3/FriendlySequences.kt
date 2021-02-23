class FriendlySequences {
    private val Int.bits: Int
        get() {
            var c = this
            var re = 0
            while (c != 0) {
                re = 1 shl (c % 10) or re
                c /= 10
            }
            return re
        }

    fun count(array: IntArray): Int {
        if (array.isEmpty())
            return 0

        var l = 0
        var count = 0
        var p = array[0].bits
        for (i in 1 until array.size) {
            val c = array[i].bits
            if (p == c)
                ++l
            else
                l = 0
            count += l
            p = c
        }
        return count
    }
}
