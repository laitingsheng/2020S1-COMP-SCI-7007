import java.util.PriorityQueue

class FamilyTravel {
    data class Stop(@JvmField val dist: Int, @JvmField val prevDist: Int, @JvmField val src: Int) : Comparable<Stop> {
        override fun compareTo(other: Stop): Int = dist - other.dist
    }

    fun shortest(edges: Array<String>): Int {
        val m = edges.first().length
        val converted = Array(edges.size) { i ->
            val s = edges[i]
            IntArray(m) { j ->
                when (val c = s[j]) {
                    in 'a' .. 'z' -> c - 'a' + 1
                    in 'A' .. 'Z' -> c - 'A' + 27
                    else -> 53
                }
            }
        }

        val q = PriorityQueue<Stop>()
        q.add(Stop(0, 52, 0))

        val md = Array(m) {
            val re = IntArray(54)
            re.fill(Int.MAX_VALUE)
            re
        }
        md[0][53] = 0

        while (q.isNotEmpty()) {
            val (d, pd, src) = q.poll()
            if (src == 1)
                return d

            converted[src].forEachIndexed { index, i ->
                if (i <= pd) {
                    val nd = d + i
                    if (nd < md[index][i]) {
                        md[index][i] = nd
                        q.add(Stop(nd, i, index))
                    }
                }
            }
        }

        return -1
    }
}
