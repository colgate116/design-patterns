fun main() {
    KotlinLogger.addLogInfo("1")
    KotlinLogger.addLogInfo("2")
    KotlinLogger.addLogInfo("3")
    KotlinLogger.addLogInfo("4")
    KotlinLogger.addLogInfo("5")
    KotlinLogger.showLogFile()
}

object KotlinLogger{
    private var logFile: String = "This is log file\n\n"
    fun addLogInfo(info: String){
        logFile = "$logFile$info\n"
    }
    fun showLogFile(){
        println(logFile)
    }
}