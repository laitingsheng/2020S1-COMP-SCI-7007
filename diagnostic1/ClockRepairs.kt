class ClockRepairs {
    fun days(arrivals: IntArray, numPerDay: Int): Int {
        var days = 0
        var remain = 0
        arrivals.forEach {
            if (it != 0 || remain != 0) {
                ++days
                remain = Math.max(0, remain + it - numPerDay)
            }
        }
        val re = days + remain / numPerDay
        return if (remain % numPerDay == 0) re else re + 1
    }
}
