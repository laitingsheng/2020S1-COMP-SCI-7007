class FewestFactors {
    private fun IntArray.swap(l: Int, r: Int) {
        val tmp = this[l]
        this[l] = this[r]
        this[r] = tmp
    }

    private val IntArray.number: Int
        get() = fold(0) { acc, it -> 10 * acc + it }

    private val Int.factors: Int
        get() {
            var nf = 0
            var f = 1
            while (f * f < this) {
                if (this % f == 0)
                    nf += 2
                ++f
            }
            if (f * f == this)
                ++nf
            return nf
        }

    fun number(digits: IntArray): Int {
        var mn = digits.number
        var mnf = mn.factors
        val s = digits.size
        val weights = IntArray(s)
        var i = 1
        while (i < s) {
            if (weights[i] < i) {
                digits.swap(i, if (i % 2 == 0) 0 else weights[i])

                val n = digits.number
                val nf = n.factors
                if (nf < mnf) {
                    mnf = nf
                    mn = n
                } else if (nf == mnf && n < mn)
                    mn = n

                ++weights[i]
                i = 1
            } else {
                weights[i] = 0
                ++i
            }
        }
        return mn
    }
}
