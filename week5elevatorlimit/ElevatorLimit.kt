class ElevatorLimit {
    fun getRange(enter: IntArray, exit: IntArray, physicalLimit: Int): IntArray {
        var sum = 0
        var min = 0
        var max = 0
        for (i in enter.indices) {
            val ex = exit[i]
            if (ex > physicalLimit)
                return intArrayOf()
            sum -= ex
            if (sum < min)
                min = sum
            val en = enter[i]
            if (en > physicalLimit)
                return intArrayOf()
            sum += en
            if (sum > max)
                max = sum
            if (max - min > physicalLimit)
                return intArrayOf()
        }
        return intArrayOf(-min, physicalLimit - max)
    }
}
