package org.spacetrader.util;

import java.io.File;

// TODO small, merge with other class maybe
public class Path {

    public static String combine(String baseDirectory, String subdir) {
        return baseDirectory + File.separator + subdir;
    }

    public static String getDefaultExtension(String filename, String extension) {
        return getExtension(filename) == null ? filename + extension : filename;
    }

    public static String removeExtension(String s) {
        int sep = s.lastIndexOf(File.separatorChar);
        int dot = s.lastIndexOf('.');
        return (dot <= sep) ? s : s.substring(0, dot);
    }

    public static String getExtension(String s) {
        int sep = s.lastIndexOf(File.separatorChar);
        int dot = s.lastIndexOf('.');
        return (dot <= sep) ? null : s.substring(dot);
    }
}
