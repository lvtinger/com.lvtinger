package com.lvtinger.core.common;

import java.io.File;

public final class FileUtils {
    public static boolean isNotDirectory(File file){
        return file == null || !file.isDirectory();
    }
    public static boolean isDirectory(File file){
        return file != null && file.isDirectory();
    }
}
