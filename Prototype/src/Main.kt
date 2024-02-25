fun main() {
    val unit = Unit(1,1,1)
    val unit1 =unit.copy(power = 2, stamina = 2)
    println("$unit $unit1")
}

data class Unit(val health: Int, val power: Int, val stamina: Int)