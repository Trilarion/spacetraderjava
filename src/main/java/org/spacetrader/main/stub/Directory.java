package org.spacetrader.main.stub;

import org.spacetrader.util.Convertor;
import org.spacetrader.util.Lisp;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;


public class Directory {
    public static String[] GetFiles(String path, String filter) {
        if (!filter.startsWith("*.")) {
            new Error("unsupported format").printStackTrace();
        }
        final String suffix = filter.substring(2);
        File[] files = new File(path).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File arg0, String filename) {
                return filename.endsWith(suffix);
            }
        });
        if (files == null) {
            System.out.println("getFiles rets null!");
            return new String[0];
        }
        List<String> names = Lisp.map(files, new Convertor<>() {
            @Override
            public String convert(File file) {
                return file.getPath();
            }
        });
        return names.toArray(new String[names.size()]);
    }

    public static boolean Exists(String path) {
        return new File(path).exists();
    }

    public static void CreateDirectory(String path) {
        if (!new File(path).mkdir()) {
            System.out.println("Couldn't make dir " + path);
        }
    }
}
