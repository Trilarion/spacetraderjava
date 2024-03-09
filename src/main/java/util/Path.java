package util;
import java.io.File;


public class Path {
  public static String Combine(String baseDirectory, String subdir) {
    return baseDirectory + File.separator + subdir;
  }

  public static String DefaultExtension(String filename, String extension) {
    return GetExtension(filename) == null ? filename + extension : filename;
  }

  public static String RemoveExtension(String s) {
    int sep = s.lastIndexOf(File.separatorChar);
    int dot = s.lastIndexOf('.');
    return (dot <= sep) ? s : s.substring(0, dot);
  }

  public static String GetExtension(String s) {
    int sep = s.lastIndexOf(File.separatorChar);
    int dot = s.lastIndexOf('.');
    return (dot <= sep) ? null : s.substring(dot);
  }
}
