class UnwindData {
    fun unwind(data: String): String {
        val s = IntArray(data.length / 3)
        var sn = -1
        val sb = StringBuilder(data)
        var i = sb.length - 1
        while (i >= 0) {
            when (val c = data[i]) {
                in '0'..'9' -> {
                    val e = sb.length - s[sn--]
                    val sec = sb.substring(i + 1, e).repeat(c - '0')
                    --i
                    sb.replace(i, e + 1, sec)
                }
                ']' -> s[++sn] = sb.length - i
            }
            --i
        }
        return sb.toString()
    }
}
