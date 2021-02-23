class TwoStringMasks {
    private val IMPOSSIBLE: String = "impossible"

    private fun String.trim(b: Int): String {
        var i = b
        while (this[i] != '*')
            ++i
        return removeRange(i, i + 1)
    }

    private fun String.combine(b1: Int, e1: Int, other: String, b2: Int, e2: Int): String {
        val nb2 = b2 + 1
        var tb1 = b1
        var l1 = e1 - tb1
        val l2 = e2 - nb2 + 1
        if (l1 > l2) {
            tb1 += l1 - l2
            l1 = l2
        }
        while (tb1 < e1 && subSequence(tb1, tb1 + l1) != other.subSequence(nb2, nb2 + l1)) {
            ++tb1
            --l1
        }
        val sb = StringBuilder(tb1 + other.length - b2)
        sb.append(this, 0, tb1)
        sb.append(other, nb2, other.length)
        return sb.toString()
    }

    fun shortestCommon(s1: String, s2: String): String {
        var b1 = 0
        var b2 = 0
        var c1 = s1[b1]
        var c2 = s2[b2]
        while (c1 != '*' && c2 != '*') {
            if (c1 != c2)
                return IMPOSSIBLE
            c1 = s1[++b1]
            c2 = s2[++b2]
        }

        var e1 = s1.length - 1
        var e2 = s2.length - 1
        c1 = s1[e1]
        c2 = s2[e2]
        while (c1 != '*' && c2 != '*') {
            if (c1 != c2)
                return IMPOSSIBLE
            c1 = s1[--e1]
            c2 = s2[--e2]
        }

        return when {
            b1 == e1 -> s2.trim(b2)
            b2 == e2 -> s1.trim(b1)
            s1[e1] == '*' -> s1.combine(b1, e1, s2, b2, e2)
            else -> s2.combine(b2, e2, s1, b1, e1)
        }
    }
}
