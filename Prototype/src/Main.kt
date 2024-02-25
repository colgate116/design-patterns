fun main() {
    val unit = Unit(1,1,1)
    val unit1 =unit.copy(power = 2, stamina = 2)
    println("$unit $unit1")

    val knight = Knight()
    val knight1:Knight =knight.copy()
    println(knight1)
}

data class Unit(val health: Int, val power: Int, val stamina: Int)

class Knight: Copyable{
    val health: Int = 30
    var power: Int = 3
    val stamina: Int = 3
    override fun copy(): Knight {
        return this
    }

    override fun toString(): String {
        return "Knight(health=$health, power=$power, stamina=$stamina)"
    }
}
