class ProblemsToSolve {
    fun minNumber(pleasantness: IntArray, variety: Int): Int {
        var re = pleasantness.size
        for (i in 1 until re)
            for (j in 0 until i)
                if (Math.abs(pleasantness[i] - pleasantness[j]) >= variety)
                    re = Math.min(re, (j + 1) / 2 + (i - j + 1) / 2 + 1)
        return re
    }
}
