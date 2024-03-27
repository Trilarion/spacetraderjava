package org.winforms.util;

import java.util.LinkedList;
import java.util.List;


// TODO what is this good for, better name and documentation
public enum Lisp {
    ;

    public static <To, From> List<To> map(final Iterable<From> k, final Convertor<To, From> conv) {
        final LinkedList<To> fname = new LinkedList<>();
        for (final From from : k) {
            fname.addLast(conv.convert(from));
        }
        return fname;
    }

    public static <To, From> List<To> map(final From[] k, final Convertor<To, From> conv) {
        final LinkedList<To> fname = new LinkedList<>();
        for (final From from : k) {
            fname.addLast(conv.convert(from));
        }
        return fname;
    }

    public static <T> List<T> filter(final T[] k, final Predicate<T> pred) {
        final LinkedList<T> fname = new LinkedList<>();
        for (final T t : k) {
            if (pred.consider(t)) {
                fname.addLast(t);
            }
        }
        return fname;
    }

    public static <T> List<T> filter(final Iterable<T> k, final Predicate<T> pred) {
        final LinkedList<T> fname = new LinkedList<>();
        for (final T t : k) {
            if (pred.consider(t)) {
                fname.addLast(t);
            }
        }
        return fname;
    }
}
