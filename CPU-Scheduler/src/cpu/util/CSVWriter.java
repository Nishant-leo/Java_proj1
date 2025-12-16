package cpu.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class CSVWriter {

    public static void writeLines(String filePath, List<String> lines) {
        try {
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}