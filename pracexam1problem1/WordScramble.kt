class WordScramble {
    fun translate(word: String): String {
        val s = word.length
        val sbv = StringBuilder(s)
        val sbo = StringBuilder(s)
        word.forEach {
            when (it.toLowerCase()) {
                'a', 'e', 'i', 'o', 'u' -> sbv
                else -> sbo
            }.append(it)
        }
        return sbo.append(sbv).toString()
    }
}
