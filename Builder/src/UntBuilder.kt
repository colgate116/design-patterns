class UntBuilder(level: Int) {
    private val config: UnitConfigs = when (level){
        1 -> FirstLevelUnitConfig()
        2 -> SecondLevelUnitConfig()
        3 -> ThirdLevelUnitConfig()
        else -> throw Exception()
    }
    private val health = config.health
    private val power = config.power
    private val stamina = config.stamina

    fun buildUnit(description: String): Unit {
        val unit = Unit(health, power, stamina, description)
        println("add $unit to db")
        return unit
    }
}