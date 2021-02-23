class Inchworm {
    private tailrec infix fun Int.gcd(b: Int): Int = if (b == 0) this else b gcd (this % b)

    fun lunchtime(branch: Int, rest: Int, leaf: Int): Int = branch / (rest / (rest gcd leaf) * leaf) + 1
}
