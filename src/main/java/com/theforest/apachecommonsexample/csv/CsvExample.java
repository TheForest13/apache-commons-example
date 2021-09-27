package com.theforest.apachecommonsexample.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Component for reading and writing comma separated value files.
 */
public class CsvExample {
    private static final Map<String, String> AUTHOR_BOOK_MAP = new HashMap<>() {
        {
            put("Dan Simmons", "Hyperion");
            put("Douglas Adams", "The Hitchhiker's Guide to the Galaxy");
        }
    };
    private static final String[] HEADERS = {"author", "title"};

    public static void main(String[] args) throws IOException {
//        readingColumnValues();
//        readingCsvFile();
//        createCSVFile();
        accessingColumnsByPredefinedHeaders();
    }

    private static void accessingColumnsByPredefinedHeaders() throws IOException {
        Reader in = new FileReader(new File("src\\main\\resources\\book1.csv"));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader("author", "title").parse(in);
        for (CSVRecord record : records) {
            String author = record.get("author");
            System.out.println("author := " + author);
            String title = record.get("title");
            System.out.println("title := " + title);
        }
    }

    private static void createCSVFile() throws IOException {
        FileWriter out = new FileWriter("src\\main\\resources\\book_new.csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(HEADERS))) {
            AUTHOR_BOOK_MAP.forEach((author, title) -> {
                try {
                    printer.printRecord(author, title);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void readingCsvFile() throws IOException {
        Reader in = new FileReader(new File("src\\main\\resources\\book1.csv"));

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            String author = record.get("author");
            System.out.println("author := " + author);
            String title = record.get("title");
            System.out.println("title := " + title);
//            System.out.println("AUTHOR_BOOK_MAP :=" + AUTHOR_BOOK_MAP.get(author));
        }
    }

    /**
     * Это самый простой способ чтения значений столбцов. Это можно использовать, когда заголовки файлов CSV неизвестны:
     *
     * @throws IOException
     */
    private static void readingColumnValues() throws IOException {
        Reader in = new FileReader(new File("src\\main\\resources\\fileCsv.csv"));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for (CSVRecord record : records) {
            String columnOne = record.get(0);
            System.out.println(columnOne);
            String columnTwo = record.get(1);
        }
    }
}
