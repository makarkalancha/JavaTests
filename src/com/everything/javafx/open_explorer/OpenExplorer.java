package com.everything.javafx.open_explorer;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by mcalancea
 * Date: 17 Jan 2018
 * Time: 09:39
 */
//https://stackoverflow.com/questions/9692331/open-a-path-with-desktop-open-from-java-on-ubuntu-linux
public class OpenExplorer {
    public static void main(String[] args) {
        Desktop desktop = null;
        // Before more Desktop API is used, first check
        // whether the API is supported by this particular
        // virtual machine (VM) on this particular host.
        if (!Desktop.isDesktopSupported()) {
            // show Error
            return;
        }
        desktop = Desktop.getDesktop();
        String path = "c:\\";
//        String path = "/run";//linux path tested successfully
        // by the way: I use System.getProperty("file.separator") as file seperator
        try {
            File fPath=new File(path);
            if(!fPath.exists()){
                // show Error
                return;

            }
            if(!fPath.isDirectory()){
                // show Error
                return;

            }
            desktop.open(new File(path));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            // show Error
            return;
        }
    }
}
