class RockStar {
    fun getNumSongs(ff: Int, fs: Int, sf: Int, ss: Int): Int = when {
        fs != 0 -> ff + ss + if (fs > sf) 2 * sf + 1 else 2 * fs
        ff != 0 -> ff
        else -> ss + if (sf != 0) 1 else 0
    }
}
