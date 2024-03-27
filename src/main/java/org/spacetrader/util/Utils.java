package org.spacetrader.util;


import org.winforms.util.Convertor;
import org.winforms.util.Lisp;

import java.io.*;
import java.util.List;

// TODO document and maybe merge with others
public enum Utils {
    ;

    public static <T> boolean arrayContains(final T[] array, final T item) {
        for (final T t : array) {
            if (t == item) {
                return true;
            }
        }
        return false;
    }

    public static int bruteSeek(final int[] array, final int a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public static String stringsJoin(final String separator, final String[] values) {
        final StringBuilder builder = new StringBuilder();
        for (final String string : values) {
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
    public static Object deserialize(final FileInputStream inputStream) throws SerializationException, IOException {
        try {
            return new ObjectInputStream(inputStream).readObject();
        } catch (final ClassNotFoundException e) {
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
    public static void Serialize(final FileOutputStream outputStream, final Object toSerialize) throws IOException {
        new ObjectOutputStream(outputStream).writeObject(toSerialize);
    }

    public static String[] getFiles(final String path, final String filter) {
        if (!filter.startsWith("*.")) {
            new Error("unsupported format").printStackTrace();
        }
        String suffix = filter.substring(2);
        final File[] files = new File(path).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File arg0, final String filename) {
                return filename.endsWith(suffix);
            }
        });
        if (files == null) {
            System.out.println("getFiles rets null!");
            return new String[0];
        }
        final List<String> names = Lisp.map(files, new Convertor<>() {
            @Override
            public String convert(final File file) {
                return file.getPath();
            }
        });
        return names.toArray(new String[names.size()]);
    }

    public static boolean existsFile(final String path) {
        return new File(path).exists();
    }

    public static void createDirectory(final String path) {
        if (!new File(path).mkdir()) {
            System.out.println("Couldn't make dir " + path);
        }
    }

    public static String combine(final String baseDirectory, final String subdir) {
        return baseDirectory + File.separator + subdir;
    }

    // TODO why not used?
    public static String getDefaultExtension(final String filename, final String extension) {
        return Utils.getExtension(filename) == null ? filename + extension : filename;
    }

    public static String removeExtension(final String s) {
        final int sep = s.lastIndexOf(File.separatorChar);
        final int dot = s.lastIndexOf('.');
        return (dot <= sep) ? s : s.substring(0, dot);
    }

    public static String getExtension(final String s) {
        final int sep = s.lastIndexOf(File.separatorChar);
        final int dot = s.lastIndexOf('.');
        return (dot <= sep) ? null : s.substring(dot);
    }
}
