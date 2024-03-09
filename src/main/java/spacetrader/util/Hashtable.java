package spacetrader.util;


//TODO revert back to java.util.Hashtable<Key, Value> ASAP
public class Hashtable extends java.util.Hashtable<String, Object> {
  private static final long serialVersionUID = 1L;

  public void add(String key, Object val) {
    put(key, val);
  }
}
