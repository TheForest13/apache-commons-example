package com.theforest.apachecommonsexample.io;

import org.apache.commons.io.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Collection of I/O utilities.
 */
public class IoExample {
    public static void main(String[] args) {
//        readByteFromUrl();
//        readByteFromUrlWithIOUtils();
//        readAnEntireFileLineByLine();
//        normalizedFileName();
//        findFreeSpaceOnDrive();
    }

    /**
     * The FileSystemUtils class contains utility methods for working with the file system to access functionality
     * not supported by the JDK. Currently, the only method is to get the free space on a drive.
     * Note that this uses the command line, not native code.
     */
    private static void findFreeSpaceOnDrive() {
        try {
            long freeSpace = FileSystemUtils.freeSpace("C:/");
            System.out.println(freeSpace / 1024 / 1024 / 1024); // GB
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The FilenameUtils class contains utility methods for working with filenames without using File objects.
     * The class aims to be consistent between Unix and Windows, to aid transitions between these environments
     * (such as moving from development to production).
     */
    private static void normalizedFileName() {
        String filename = "src/main/../database.properties";
        String normalized = FilenameUtils.normalize(filename);
        System.out.println(normalized);
    }

    /**
     * The FileUtils class contains utility methods for working with File objects.
     *  These include reading, writing, copying and comparing files.
     */
    private static void readAnEntireFileLineByLine() {
        File file = new File("src/main/resources/database.properties");
        try {
            List lines = FileUtils.readLines(file, "UTF-8");
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readByteFromUrlWithIOUtils() {
        InputStream in = null;
        try {
            in = new URL("https://commons.apache.org").openStream();
            System.out.println(IOUtils.toString(in));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    private static void readByteFromUrl() {
        InputStream in = null;
        try {
            in = new URL("https://commons.apache.org").openStream();
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(inR);
            String line;
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
