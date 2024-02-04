interface Developer {
    val name: String
    fun writeCode()
}

class KotlinDeveloper(override val name: String) : Developer {
    override fun writeCode() {
        println("Creating mobile app for android...")
    }
}

class SwiftDeveloper(override val name: String) : Developer{
    override fun writeCode() {
        println("Creating mobile app for IOS...")
    }
}

class PhpDeveloper(override val name: String): Developer{
    val pos = 4

    override fun writeCode() {
        println("Creating web-site...")
    }

}