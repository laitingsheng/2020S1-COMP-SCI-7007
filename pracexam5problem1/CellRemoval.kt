class CellRemoval {
    private tailrec fun recurse(parent: IntArray, ignored: Int, s: Int, acc: Int): Int {
        return when (s) {
            -1 -> acc + 1
            ignored -> acc
            else -> recurse(parent, ignored, parent[s], acc)
        }
    }

    fun cellsLeft(parent: IntArray, deletedCell: Int): Int = BooleanArray(parent.size).apply {
        parent.forEach { p -> if (p != -1) this[p] = true }
    }.foldIndexed(0) { i, acc, b ->
        if (b) acc else recurse(parent, deletedCell, i, acc)
    }
}
