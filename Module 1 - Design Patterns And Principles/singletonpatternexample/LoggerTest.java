package singletonpatternexample;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance(), logger2 = Logger.getInstance(), logger3 = Logger.getInstance();
        logger1.addEntry("Server Started");
        logger1.addEntry("User 1 joined");
        logger2.addEntry("User 2 joined");

        logger3.printLog();
    }
}