class StringSegment {
    fun average(s: String): Double {
        var l = 1
        s.reduce { p, c ->
            if (c != p)
                ++l
            c
        }
        return s.length.toDouble() / l
    }
}
