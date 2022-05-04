class TicketMachine(var currentTariff: Tariff) {
    val parkTickets = mutableListOf<ParkTicket>()


    fun generate(entryTime : Time) : ParkTicket {
        val newParkTicket = ParkTicket(entryTime)
        parkTickets.add(newParkTicket)
        return newParkTicket
    }

    fun validTickets() : List<ParkTicket> {
        val validParkTickets = mutableListOf<ParkTicket>()
        for (parkTicket in this.parkTickets) {
            if (parkTicket.valid == true) {
                validParkTickets.add(parkTicket)
            }
        }
        return validParkTickets
    }

    fun shortestParkingDuration() : Int {
        val validTicketList = validTickets()
        var shortestParkDurationIndex = 0
        var index = 0
        for (parkTicket in validTicketList) {
            if (validTicketList[shortestParkDurationIndex].parkingDuration > parkTicket.parkingDuration)
                shortestParkDurationIndex = index
        index++
        }
        return validTicketList[shortestParkDurationIndex].parkingDuration
    }

    fun averageParkingDuration() : Int {
        val validTicketList = validTickets()
        var sumParkingDuration = 0
        for (parkTicket in validTicketList)
            sumParkingDuration += parkTicket.parkingDuration
        return sumParkingDuration/validTicketList.size
    }

    fun revenues() : Double {
        val validTicketList = validTickets()
        var sumHoursStarted = 0
        for (parkTicket in validTicketList)
            sumHoursStarted += parkTicket.hoursStarted
        return sumHoursStarted * currentTariff.price()
    }
}