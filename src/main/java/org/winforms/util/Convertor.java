package org.winforms.util;


// TODO only used in a small place (image resource handling) really needed?
public interface Convertor<To, From> {
    To convert(From f);
}
