package org.spacetrader.main.util;


public class Util {
  public static <T> boolean ArrayContains(T[] array, T item) {
    for(T t : array) {
      if(t == item) {
        return true;
      }
    }
    return false;
  }

  public static int BruteSeek(int[] array, int a) {
    for(int i = 0; i < array.length; i++) {
      if(array[i] == a) {
        return i;
      }
    }
    return -1;
  }

  public static String StringsJoin(String seperator, String[] values) {
    StringBuilder sb = new StringBuilder("");
    for(String string : values) {
      sb.append(string);
      sb.append(seperator);
    }
    return sb.toString();
  }
}
