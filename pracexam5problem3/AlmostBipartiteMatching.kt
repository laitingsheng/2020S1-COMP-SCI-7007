class AlmostBipartiteMatching {
    fun maxMatching(nA: Int, nB: Int, edgesA: IntArray, edgesB: IntArray): Int {
        val re = (nA + nB) / 2
        if (nA % 2 == 0 || nB % 2 == 0)
            return re
        for (i in edgesA.indices)
            if (edgesA[i] % 2 == 0 && edgesB[i] % 2 == 0)
                return re
        return re - 1
    }
}
