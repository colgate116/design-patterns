class GreenKnight: Knight() {
    override fun attack() {
        println("Зеленая атака рыцаря")
    }
}

class GreenBeast: Beast() {
    override fun attack() {
        println("Зеленая атака зверя")
    }
}

class GreenMage: Mage() {
    override fun attack() {
        println("Зеленая атака мага")
    }
}