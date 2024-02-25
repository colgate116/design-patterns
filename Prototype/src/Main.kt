fun main() {
    val unit = Unit(1,1,1)
    val unit1 =unit.copy(power = 2, stamina = 2)
    println("$unit $unit1")

    val knight = Knight()
    val knight1 =knight.copy()
}

data class Unit(val health: Int, val power: Int, val stamina: Int)

class Knight: Copyable{
    val health: Int = 30
    val power: Int = 3
    val stamina: Int = 3
    override fun copy(): Knight {
        val knight = this
        return knight
    }
}
