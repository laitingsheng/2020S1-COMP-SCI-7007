class EmoticonsDiv2 {
    fun printSmiles(smiles: Int): Int {
        val counts = IntArray(smiles + 1) { i -> i }
        for (i in 2 until smiles / 2) {
            var c = i * 2
            var ci = 2
            while (c <= smiles) {
                counts[c] = Math.min(counts[c], counts[i] + ci)
                c += i
                ++ci
            }
        }
        return counts[smiles]
    }
}
