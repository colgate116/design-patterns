fun main() {
    val unit: Unit = BuildUnit()
        .health(40)
        .power(30)
        .buildUnit()
    println(unit)
}