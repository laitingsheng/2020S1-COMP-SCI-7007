class ColourSets {
    fun maxPoints(points: Array<String>): Int {
        val sb = StringBuilder()
        points.forEach { p -> sb.append(p) }
        val strings = sb.split(' ')
        val converted = IntArray(strings.size) { i -> strings[i].toInt() }

        var re = 0
        for (i in 1 until 360) {
            val reachable = BooleanArray(360)
            converted.forEach { d -> reachable[d] = true }

            var cre = 0
            converted.forEach { d ->
                var c = 0
                var cd = d
                while (reachable[cd]) {
                    ++c
                    reachable[cd] = false
                    cd = (cd + i) % 360
                }
                cd = (d - i + 360) % 360
                while (reachable[cd]) {
                    ++c
                    reachable[cd] = false
                    cd = (cd - i + 360) % 360
                }
                cre += c - c % 2
            }
            re = cre.coerceAtLeast(re)
        }
        return re
    }
}
