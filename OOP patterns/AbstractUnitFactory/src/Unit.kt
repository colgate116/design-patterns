interface  Unit{
    val health: Int
    fun move()
    fun attack()
}

abstract class Mage: Unit{
    override val health: Int
        get() = 100

    override fun move() {
        println("Маг двигается...")
    }
}

abstract class Knight: Unit {
    override val health: Int
        get() = 200

    override fun move() {
        println("Рыцарь идет...")
    }
}

abstract class Beast: Unit{
    override val health: Int
        get() = 1000

    override fun move() {
        println("Зверь потопал...")
    }
}

