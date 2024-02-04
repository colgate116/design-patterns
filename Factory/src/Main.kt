fun main() {
    val developer1: Developer = developerFactory(Developers.SWIFT_DEV, "Peter").createDeveloper()
    val developer2: Developer = developerFactory(Developers.KOTLIN_DEV, "Alex").createDeveloper()
    val developer3: Developer = developerFactory(Developers.KOTLIN_DEV, "Nikolay").createDeveloper()
    val developer4: Developer = developerFactory(Developers.SWIFT_DEV, "Vladimir").createDeveloper()
    val developer5: Developer = developerFactory(Developers.PHP_DEV, "Vladimir").createDeveloper()
    val developer6: Developer = developerFactory(Developers.PHP_DEV, "Alex").createDeveloper()
    developer6.writeCode()

}

fun developerFactory(developer: Developers, name: String): DeveloperFactory {
    return when (developer){
        Developers.KOTLIN_DEV -> KotlinDeveloperFactory(name)
        Developers.SWIFT_DEV -> KotlinDeveloperFactory(name)
        Developers.PHP_DEV -> PhpDeveloperFactory(name)
    }
}

enum class Developers{
    KOTLIN_DEV, SWIFT_DEV, PHP_DEV
}