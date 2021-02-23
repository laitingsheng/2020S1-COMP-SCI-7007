class DestroyBall {
    private val red: String = "RED"
    private val green: String = "GREEN"
    private val blue: String = "BLUE"

    fun ballColor(r: Long, g: Long, b: Long, k: Long): String {
        val rgb = longArrayOf(r, g, b)
        rgb.sort()
        var c = k
        val f = rgb[0]
        if (c <= 3 * f)
            return when ((c - 1) % 3) {
                0L -> red
                1L -> green
                else -> blue
            }

        c -= 3 * f
        rgb[1] -= f
        if (c <= 2 * rgb[1])
            return when (f) {
                r -> if ((c - 1L) % 2L == 0L) green else blue
                g -> if ((c - 1L) % 2L == 0L) red else blue
                else -> if ((c - 1L) % 2L == 0L) red else green
            }

        return when (rgb[2]) {
            r -> red
            g -> green
            else -> blue
        }
    }
}
