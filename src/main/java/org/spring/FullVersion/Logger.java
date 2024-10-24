package org.spring.FullVersion;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {


    private static final String LOG_FILE = "application.log";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");


    public static void info(String message) {
        log("[DEBUG]", message);
    }


    public static void error(String message) {
        log("ERROR", message);
    }


    private static void log(String logType, String message) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedMessage = String.format("%s [%s] %s", LocalDateTime.now().format(dateTimeFormatter), logType, message);
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(formattedMessage + "\n");
        } catch (IOException e) {
            System.err.println("Unable to write to log file: " + e.getMessage());
        }
    }
}
