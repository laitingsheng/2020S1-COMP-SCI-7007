class MatchNumbersEasy {
    private fun compare(sb1: StringBuilder, sb2: StringBuilder): Int {
        if (sb1.isEmpty() || sb2.isEmpty())
            return sb1.length - sb2.length

        var nz1 = sb1.indexOfFirst { c -> c != '0' }
        if (nz1 == -1)
            nz1 = sb1.length - 1
        var nz2 = sb2.indexOfFirst { c -> c != '0' }
        if (nz2 == -1)
            nz2 = sb2.length - 1

        val l1 = sb1.length - nz1
        val l2 = sb2.length - nz2
        var cr = l1 - l2
        if (cr != 0)
            return cr
        for (i in 0 until Math.min(l1, l2)) {
            cr = sb1[nz1 + i] - sb2[nz2 + i]
            if (cr != 0)
                return cr
        }
        return 0
    }

    fun maxNumber(matches: IntArray, n: Int): String {
        val record = Array(n + 1) { StringBuilder(n) }
        var sb = StringBuilder(n)
        for (m in 1 .. n) {
            matches.forEachIndexed { i, match ->
                for (j in match .. m) {
                    val prev = record[j - match]
                    if (prev.isEmpty() || prev.first() <= '0' + i) {
                        sb.append(i)
                        sb.append(prev)
                    } else {
                        sb.append(prev)
                        sb.append(i)
                    }

                    val curr = record[m]
                    if (compare(sb, curr) > 0) {
                        record[m] = sb
                        sb = curr
                    }
                    sb.setLength(0)
                }
            }
        }

        sb.setLength(0)
        return record.foldRight(sb) { acc, isb -> if (compare(isb, acc) > 0) isb else acc }.toString()
    }
}
