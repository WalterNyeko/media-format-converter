package com.helpers;

import java.io.File;

public class FileHelper {

    public String getFileFromResource(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        String filePath = file.getAbsolutePath();
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException(Constants.FILE_NOT_FOUND + fileName);
        } else {
            return filePath;
        }
    }

    public boolean fileExists(String filePath) {
        File file = new File(filePath);
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }
}
