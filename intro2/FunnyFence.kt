class FunnyFence {
    fun getLength(s: String): Int {
        var ll = 1
        var cl = 1
        s.reduce { p, c ->
            if (c != p) {
                ++cl
                if (cl > ll)
                    ll = cl
            } else
                cl = 1
            c
        }
        return ll
    }
}
