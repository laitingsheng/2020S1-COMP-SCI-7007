import java.util.Arrays

class DeleteDuplicates {
    fun eliminate(sequence: IntArray): IntArray {
        if (sequence.isEmpty())
            return sequence
        val s = sequence.size
        var c = s - 1
        val r = HashSet<Int>(s)
        for (i in c downTo 0) {
            val it = sequence[i]
            if (it !in r) {
                r.add(it)
                if (i != c)
                    sequence[c] = it
                --c
            }
        }
        if (c == -1)
            return sequence
        return sequence.copyOfRange(c + 1, s)
    }
}
