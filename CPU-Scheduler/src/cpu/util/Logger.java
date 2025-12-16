package cpu.util;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;

public class Logger {

    private static final String LOG_FILE = "activity.log";

    public static void log(String msg) {
        String line = LocalDateTime.now() + " - " + msg + "\n";

        try {
            Files.write(Paths.get(LOG_FILE),
                    line.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}