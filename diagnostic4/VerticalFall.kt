class VerticalFall {
    data class Obstacle(@JvmField val y: Int, @JvmField val x1: Int, @JvmField val x2: Int) : Comparable<Obstacle> {
        override fun compareTo(other: Obstacle): Int = other.y - y
    }

    fun dropTime(x: Int, y: Int, obstacles: Array<String>): Int {
        val converted = ArrayList<Obstacle>(obstacles.size)
        obstacles.forEach {
            val s = it.split(' ')
            val cy = s[0].toInt()
            if (cy <= y)
                converted.add(Obstacle(cy, s[1].toInt(), s[2].toInt()))
        }
        converted.sort()
        var cx = x
        var extra = 0
        converted.forEach { (_, x1, x2) ->
            if (cx in x1 .. x2) {
                cx = x2
                extra += 5
            }
        }
        return y + extra
    }
}
