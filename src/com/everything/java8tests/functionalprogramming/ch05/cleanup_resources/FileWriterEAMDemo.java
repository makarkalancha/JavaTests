package com.everything.java8tests.functionalprogramming.ch05.cleanup_resources;

import java.io.IOException;

/**
 * Created by mcalancea on 2015-09-23.
 */
public class FileWriterEAMDemo {

    public static void main(String[] args) throws IOException{
        FileWriterEAM.use("testMe1.txt",writerEAM -> writerEAM.writeStuff("hello, world!"));

        FileWriterEAM.use("testMe2.txt",writerEAM -> {
            writerEAM.writeStuff("and again");
            writerEAM.writeStuff("hello, world!!!");
        });
    }

}
