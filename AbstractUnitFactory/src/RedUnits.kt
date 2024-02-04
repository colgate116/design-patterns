class RedKnight: Knight() {
    override fun attack() {
        println("Красная атака рыцаря")
    }
}

class RedBeast: Beast() {
    override fun attack() {
        println("Красная атака зверя")
    }
}

class RedMage: Mage() {
    override fun attack() {
        println("Красная атака мага")
    }
}