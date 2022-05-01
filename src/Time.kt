class Time (hour_parameter : Int = 0, minute_parameter : Int = 0) {

    class NegativeHourException : Exception()
    class HourOutOfBoundsException : Exception()
    class NegativeMinuteException : Exception()
    class MinuteOutOfBoundException : Exception()

    var hour = hour_parameter
    private set(value) {
        if (value < 0) {
            throw NegativeHourException()
            field = 0
        }
        else if (value > 23) {
            throw HourOutOfBoundsException()
            field = 23
        }
        else
            field = value
    }
    init {
        hour = hour_parameter
    }

    var minute = minute_parameter
    private set(value) {
        if (value < 0) {
            throw  NegativeMinuteException()
            field = 0
        }
        else if (value > 59) {
            throw MinuteOutOfBoundException()
            field = 59
        }
        else
            field = value
    }
    init {
        minute = minute_parameter
    }

}
