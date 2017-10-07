package com.everything.java8tests.functionalprogramming.ch05.cleanup_resources;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mcalancea on 2015-09-23.
 */
public class FileWriterEAM {
    private final FileWriter writer;

    public FileWriterEAM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("close called automatically...");
        writer.close();
    }

    public void writeStuff(final String message) throws IOException{
        writer.write(message);
    }

    public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block) throws IOException {
        final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
        try{
            block.accept(writerEAM);
        }finally {
            writerEAM.close();
        }
    }

}
