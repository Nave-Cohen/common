package com.navegi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileStringReader {
    public static String read(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String fileString = "";
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null)
                fileString += fileString + line;
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return fileString;
    }
    public static String read(File file) {
        BufferedReader reader = null;
        String fileString = "";
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null)
                fileString += fileString + line;
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return fileString;
    }
}
