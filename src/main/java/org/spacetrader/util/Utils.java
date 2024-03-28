package org.spacetrader.util;


import org.winforms.util.Convertor;
import org.winforms.util.Lisp;

import java.io.*;
import java.util.List;

// TODO document and maybe merge with others
public enum Utils {
    ;

    public static <T> boolean arrayContains(T[] array, T item) {
        for (T t : array) {
            if (t == item) {
                return true;
            }
        }
        return false;
    }

    public static int bruteSeek(int[] array, int a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public static String stringsJoin(String separator, String[] values) {
        StringBuilder builder = new StringBuilder();
        for (String string : values) {
            builder.append(string);
            builder.append(separator);
        }
        return builder.toString();
    }

    /**
     * For loading from binary file stream.
     *
     * @param inputStream
     * @return
     * @throws SerializationException
     * @throws IOException
     */
    public static Object deserialize(FileInputStream inputStream) throws SerializationException, IOException {
        try {
            return new ObjectInputStream(inputStream).readObject();
        } catch (ClassNotFoundException e) {
            throw new SerializationException(e);
        }
    }

    /**
     * For writing to binary file stream.
     *
     * @param outputStream
     * @param toSerialize
     * @throws IOException
     */
    public static void Serialize(FileOutputStream outputStream, Object toSerialize) throws IOException {
        new ObjectOutputStream(outputStream).writeObject(toSerialize);
    }

    public static String[] getFiles(String path, String filter) {
        if (!filter.startsWith("*.")) {
            new Error("unsupported format").printStackTrace();
        }
        String suffix = filter.substring(2);
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

    public static boolean existsFile(String path) {
        return new File(path).exists();
    }

    public static void createDirectory(String path) {
        if (!new File(path).mkdir()) {
            System.out.println("Couldn't make dir " + path);
        }
    }

    public static String combine(String baseDirectory, String subdir) {
        return baseDirectory + File.separator + subdir;
    }

    // TODO why not used?
    public static String getDefaultExtension(String filename, String extension) {
        return Utils.getExtension(filename) == null ? filename + extension : filename;
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
