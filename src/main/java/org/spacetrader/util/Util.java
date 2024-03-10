package org.spacetrader.util;


// TODO document and maybe merge with others
public class Util {

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
}
