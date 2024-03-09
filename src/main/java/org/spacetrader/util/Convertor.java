package org.spacetrader.util;


public interface Convertor<To, From> {
  To convert(From f);
}
