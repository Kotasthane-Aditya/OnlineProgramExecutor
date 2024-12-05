package com.executor.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import com.reference.Language;


@Component
public class ExecutionInfo {

    public String show(Language language, Process process) {
        String executionOutput = "";
        try {
            BufferedReader executionOutputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader executionErrorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            /**
             * PRINTING PROGRAM COMPILATION/EXECUTION OUTPUT
             */
            executionOutput += "Output: " + System.lineSeparator();
            String s = null;
            while ((s = executionOutputStream.readLine()) != null) {
                executionOutput += s + System.lineSeparator();
            }

            executionOutput += "Error (if any):" + System.lineSeparator();
            while ((s = executionErrorStream.readLine()) != null) {
                // System.out.println(s);
                executionOutput += s + System.lineSeparator();
            }
            return executionOutput;
        } catch (IOException e) {
            executionOutput += "Service execution error";
            e.printStackTrace();
        }
        return "";
    }
}
