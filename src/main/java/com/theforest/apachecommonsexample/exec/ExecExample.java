package com.theforest.apachecommonsexample.exec;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;

/**
 * API for dealing with external process execution and environment management in Java.
 */
public class ExecExample {
    public static void main(String[] args) throws IOException {
        String line = "help";
        CommandLine cmdLine = CommandLine.parse(line);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        int exitValue = executor.execute(cmdLine);
        System.out.println(exitValue);
    }
}
