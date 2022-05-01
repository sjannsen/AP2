enum class Tariff {
    STANDARD {
        override fun price() = 1.99
    },
    EVENT {
        override fun price() = 1.49
    },
    WEEKEND {
        override fun price() = 2.99
    };

    abstract fun price(): Double
}