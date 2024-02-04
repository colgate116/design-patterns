class BlueKnight: Knight() {
    override fun attack() {
        println("Синий атака рыцаря")
    }
}

class BlueBeast: Beast() {
    override fun attack() {
        println("Синий атака зверя")
    }
}

class BlueMage: Mage() {
    override fun attack() {
        println("Синий атака мага")
    }
}