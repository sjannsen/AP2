fun main() {
//    val time1 = Time(12, 0) // valide Uhrzeit
//    val time2 = Time(12, 30) // valide Uhrzeit
//   val time3 = Time (26 , 120) // invalide Uhrzeit . Programm stürzt mit einer Fehlermeldung ( Exception ) ab.
//    val time4 = Time (-5, -10) // invalide Uhrzeit . Programm stürzt miteiner Fehlermeldung ( Exception ) ab.
//
//    val entryTime = Time(12, 0)
//    val ticket = ParkTicket(entryTime)
//    ticket.checkout(Time(12, 30)) // funktioniert. Parkdauer beträgt 30 min
//
//    ticket.checkout ( Time (11 , 0)) // funktioniert nicht. Parkdauer kann nicht negativ sein. Programm stürzt mit einer Fehlermeldung ( Exception ) ab
//
//
//    val entryTime = Time(12, 0)
//    val ticket = ParkTicket(entryTime)
//    ticket.checkout(Time(12, 30)) // funktioniert, weil 12:00 < 12:30
//    println(ticket.parkingDuration()) // Gibt 30 aus
//    println(ticket.hoursStarted()) // Gibt 1 aus
//    println(ticket.parkingDuration)
//    println(ticket.hoursStarted)
//
//
//    val ticket2 = ParkTicket(Time(12, 30))
//    ticket2.checkout(Time(13, 40)) // funktioniert, weil 12:30 < 13:40
//    println(ticket2.parkingDuration()) // Gibt 70 aus
//    println(ticket2.hoursStarted()) // Gibt 2 aus
//    println(ticket2.parkingDuration)
//    println(ticket2.hoursStarted)
//

//    val default = Tariff.DEFAULT
//    println(default.price()) // Gibt 1.99 aus
//    val weekend = Tariff.WEEKEND
//    println(weekend.price()) // Gibt 2.99 aus

    val machine = TicketMachine(Tariff.DEFAULT)
    val ticket1 = machine.generate(Time(12, 0))
    val ticket2 = machine.generate(Time(12, 30))
    val ticket3 = machine.generate(Time(13, 30))
    val ticket4 = machine.generate(Time(13, 30))
    ticket1.checkout(Time(12, 30)) // 30 min (1h)
    ticket2.checkout(Time(13, 30)) // 60 min (1h)
    ticket3.checkout(Time(14, 50)) // 80 min (2h)
// ticket4 wird nicht abgestempelt und wird daher für alle folgenden Methodenaufrufe nicht berücksichtigt
    println(machine.shortestParkingDuration()) // Gibt 30 aus
    println(machine.averageParkingDuration()) // Gibt 56 aus ((30 + 60 + 80) / 3)
    println(machine.revenues()) // Gibt 7.96 aus ((1 + 1 + 2) * machine.tariff.price())

}


