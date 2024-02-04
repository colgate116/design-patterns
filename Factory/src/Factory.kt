interface DeveloperFactory{
    fun createDeveloper(): Developer
    fun addToDB()
}

class KotlinDeveloperFactory(name: String) : DeveloperFactory{
    private val kotlinDeveloper = KotlinDeveloper(name)
    override fun createDeveloper(): Developer {
        addToDB()
        return kotlinDeveloper
    }
    override fun addToDB() {
        println("KotlinDev ${kotlinDeveloper.name} added to DB...")
    }
}

class SwiftDeveloperFactory(name: String) : DeveloperFactory{
    private val swiftDeveloper = SwiftDeveloper(name)
    override fun createDeveloper(): Developer {
        addToDB()
        return swiftDeveloper
    }
    override fun addToDB() {
        println("SwiftDev ${swiftDeveloper.name} added to DB...")
    }
}

class PhpDeveloperFactory(name: String) : DeveloperFactory{
    private val phpDeveloper = PhpDeveloper(name)
    override fun createDeveloper(): Developer {
        addToDB()
        return phpDeveloper
    }
    override fun addToDB() {
        println("PhpDev ${phpDeveloper.name} added to DB...")
    }
}