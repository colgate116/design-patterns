fun main() {
    while (true){
        val color = readln().toInt()
        val unit = readln().toInt()
        createFactory(color, unit).attack()
        println("Poshel nahui")
    }
}

fun createFactory(color: Int, unit: Int): Unit{
    val factory: Factory = when (color){
        1 -> GreenUnitsFactory()
        2 -> RedUnitsFactory()
        3 -> BlueUnitsFactory()
        else -> throw Exception()
    }
    return when (unit){
        1 -> factory.createMage()
        2 -> factory.createKnight()
        3 -> factory.createBeast()
        else -> throw Exception()
    }
}