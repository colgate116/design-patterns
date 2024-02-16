public class Main {
    public static void main(String[] args) {
        JavaLogger.getJavaLogger().addInfo("1");
        JavaLogger.getJavaLogger().addInfo("2");
        JavaLogger.getJavaLogger().addInfo("3");
        JavaLogger.getJavaLogger().addInfo("4");
        JavaLogger.getJavaLogger().addInfo("5");
        JavaLogger.getJavaLogger().showLogInfo();
    }
}