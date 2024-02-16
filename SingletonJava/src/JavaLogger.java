public class JavaLogger {
    private JavaLogger(){}
    private static JavaLogger javaLogger;
    public static JavaLogger getJavaLogger(){
        if (javaLogger==null)
            javaLogger = new JavaLogger();
        return javaLogger;
    }
    private static String logFile = "This is log file\n\n";
    public void addInfo(String info){
        logFile+= info+"\n";
    }
    public void showLogInfo(){
        System.out.println(logFile);
    }
}
