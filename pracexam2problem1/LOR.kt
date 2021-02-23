class LOR {
    fun maxDistance(program: String): Int {
        var curr = 0
        var extra = 0
        return program.fold(0) { acc, it ->
            when (it) {
                'L' -> --curr
                'R' -> ++curr
                '?' -> ++extra
            }
            Math.max(acc, if (curr < 0) -curr + extra else curr + extra)
        }
    }
}
