class WaiterJob {
    fun allocateTables(tables: IntArray, groupSizes: IntArray, arrivals: IntArray, departures: IntArray): Int {
        tables.sort()
        val left = IntArray(tables.size)
        var re = 0
        groupSizes.forEachIndexed { i, s ->
            var notfound = true
            for (j in tables.indices) {
                if (s <= tables[j] && arrivals[i] >= left[j]) {
                    left[j] = departures[i]
                    notfound = false
                    break
                }
            }
            if (notfound)
                re += s
        }
        return re
    }
}
