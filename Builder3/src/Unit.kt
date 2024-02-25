class Unit {
    private var health: Int = 0
    private var stamina: Int = 0
    private var power: Int = 0

    fun setHealth(value: Int) =
        apply { this.health = value }

    fun setStamina(value: Int) =
        apply { this.stamina = value }

    fun setPower(value: Int) =
        apply { this.power = value }



    override fun toString(): String {
        return "$health $stamina $power"
    }
}