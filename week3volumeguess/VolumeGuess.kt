class VolumeGuess {
    class Hint(@JvmField val box1: Int, @JvmField val box2: Int, @JvmField val volume: Int) : Comparable<Hint> {
        override operator fun compareTo(other: Hint): Int = volume - other.volume

        operator fun div(other: Hint): Int = if (box1 == other.box1 || box1 == other.box2) box1 else box2
    }

    fun correctVolume(queries: Array<String>, numberOfBoxes: Int, ithBox: Int): Int {
        val hints = Array(queries.size) { i ->
            val query = queries[i].split(',')
            Hint(query[0].toInt(), query[1].toInt(), query[2].toInt())
        }
        hints.sort()
        val volumes = IntArray(numberOfBoxes)
        var curr = 0
        for (i in (numberOfBoxes - 1) downTo 2) {
            val hint = hints[curr]
            volumes[hint / hints[curr + 1] - 1] = hint.volume
            curr += i
        }
        return volumes[ithBox - 1]
    }
}
