package com.theforest.apachecommonsexample.compress;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.utils.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Defines an API for working with tar, zip and bzip2 files.
 */
public class CompressExample {
    public static void main(String[] args) throws IOException, CompressorException, ArchiveException {

        // Create zip file stream.
        try (ZipArchiveOutputStream archive = new ZipArchiveOutputStream(new FileOutputStream("archive.zip"))) {

            // Add file to zip archive

            File file = new File("file.txt");
            ZipArchiveEntry entry_1 = new ZipArchiveEntry(file, "file-to-compress-1.txt");
            archive.putArchiveEntry(entry_1);
            IOUtils.copy(new FileInputStream(file), archive);
            archive.closeArchiveEntry();

            // Complete archive entry addition.
            archive.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
