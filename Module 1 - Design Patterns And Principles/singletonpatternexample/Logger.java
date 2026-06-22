package singletonpatternexample;

import java.util.ArrayList;

public class Logger {

    private static Logger instance;
    private final ArrayList<String> logs;
    
    private Logger() {
        this.logs = new ArrayList<>();
    }

    public static Logger getInstance() {
        if(instance == null)
            instance = new Logger();
        return instance;
    }

    public void addEntry(String message) {
        logs.add("[LOG]: " + message);
    }

    public void printLog() {
        for(String log : logs)
            System.out.println(log);
    }
}