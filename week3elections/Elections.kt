class Elections {
    fun visit(likelihoods: Array<String>): Int {
        var index = 0
        likelihoods.foldIndexed(2.0) { i, mr, c ->
            val r = c.count { it == '1' }.toDouble() / c.length
            if (r < mr) {
                index = i
                r
            } else
                mr
        }
        return index
    }
}
