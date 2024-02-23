class BuildUnit {
    private var health: Int = 10
    private var stamina: Int = 10
    private var power: Int = 10
    fun health(value: Int): BuildUnit{
        this.health = value
        return this
    }
    fun stamina(value: Int): BuildUnit{
        this.stamina = value
        return this
    }
    fun power(value: Int): BuildUnit{
        this.power = value
        return this
    }
    fun buildUnit(): Unit{
        return Unit(health = health,
            stamina = stamina,
            power = power)
    }
}