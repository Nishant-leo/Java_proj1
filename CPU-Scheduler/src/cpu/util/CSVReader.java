package cpu.util;

import cpu.process.Process;
import cpu.exception.NegativeBurstException;
import cpu.exception.OverlappingArrivalException;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class CSVReader {

    public static List<Process> readProcesses(String filePath)
            throws IOException, NegativeBurstException, OverlappingArrivalException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<Process> processes = new ArrayList<>();

        boolean headerSkipped = false;

        for (String line : lines) {
            if (!headerSkipped) { 
                headerSkipped = true;
                continue;
            }

            String[] parts = line.split(",");

            String pid = parts[0].trim();
            int arrival = Integer.parseInt(parts[1].trim());
            int burst = Integer.parseInt(parts[2].trim());

            if (burst <= 0)
                throw new NegativeBurstException("Burst time cannot be <= 0 for " + pid);

            Process p = new Process(pid, arrival, burst);
            processes.add(p);
        }

        return processes;
    }
}