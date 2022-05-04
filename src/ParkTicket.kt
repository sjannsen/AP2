import kotlin.math.ceil


class ParkTicket(entryTime_parameter: Time) {
    class InvalidCheckoutTimeException : Exception()
    class MissingCheckoutException : Exception()

    val entryTime = entryTime_parameter
    var exitTime: Time? = null
        get() = field

    //Definition der Methoden parkingDuration() und hoursStarted() als backing Properties / Eigenschaften ohne Felder
    val parkingDuration : Int
        get() {
        if (exitTime == null) {
            println("Parkticket muss vorher korrekt abgestempelt werden!")
            throw MissingCheckoutException()
        }
            return (exitTime?.hour ?: 1380) * 60 + (exitTime?.minute ?: 59) - (entryTime.hour * 60 + entryTime.minute)
    }

    val hoursStarted : Int
    get() = ceil((parkingDuration.toDouble()/60)).toInt()

  /*  val hoursStarted : Int
    get() {
        return ceil((parkingDuration.toDouble()/60)).toInt()
    }*/

    fun checkout(exitTime: Time) {
        if (exitTime.hour > entryTime.hour) this.exitTime = exitTime
        else if (exitTime.hour == entryTime.hour && exitTime.minute > entryTime.minute) this.exitTime = exitTime
        else {
            println("Ausfahrtszeit $exitTime liegt vor der Einfahrtszeit $entryTime")
            throw  InvalidCheckoutTimeException()
        }
    }

   /* fun parkingDuration(): Int {
        if (exitTime == null) {
            println("Parkticket muss vorher korrekt abgestempelt werden!")
            throw MissingCheckoutException()
        }
        //Difference of exitTime and entryTime in Minutes, ?. cause of compiler,
        //variation 1
        else if (exitTime != null) {
            val parkingDuration2 =
                (this.exitTime!!.hour * 60 + exitTime!!.minute) - (entryTime.hour * 60 + entryTime.minute)
        }
        //variation 2
        val parkingDuration =
            (exitTime?.hour ?: 1380) * 60 + (exitTime?.minute ?: 59) - (entryTime.hour * 60 + entryTime.minute)

        return parkingDuration
    }

    fun hoursStarted(): Int {
        return ceil((parkingDuration().toDouble()) / 60).toInt() //fun ceil(x : double) : Double Rounds the given value x to an integer towards positive infinity.
    }*/



}