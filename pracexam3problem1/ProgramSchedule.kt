class ProgramSchedule {
    class Program(@JvmField val prep: Int, @JvmField val running: Int): Comparable<Program> {
        override fun compareTo(other: Program): Int {
            return other.running - running
        }

        operator fun component1() = prep

        operator fun component2() = running
    }

    fun schedule(A: IntArray, B: IntArray): Int {
        val programs = Array(A.size) { i ->
            Program(A[i], B[i])
        }
        programs.sort()
        var mt = 0
        var tp = 0
        programs.forEach { (p, r) ->
            mt = (tp + p + r).coerceAtLeast(mt)
            tp += p
        }
        return mt
    }
}
