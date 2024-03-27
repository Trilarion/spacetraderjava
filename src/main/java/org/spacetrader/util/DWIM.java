package org.spacetrader.util;

import java.lang.reflect.Array;
import java.lang.reflect.Method;


// TODO what is this about?
public enum DWIM {
    ;

    /**
     * even if it's of the right type, I still take the value from the "canon" collections, because the input is likely to be from
     * the persistence; AFAIK, even for enums, the value read from the serializer, while being equals() to the canon values, are
     * not == to them. i.e.:{@code
     * MyEnum val = MyEnum.value;
     * storage.serialize(val);
     * val = storage.deserialize();
     * boolean equals = MyEnum.value(val); // true
     * boolean same = MyEnum.value == val; // false.
     * }
     */

    public static <T extends IdentifiableEnum> T dwim(final Object ob, final Class<T> cls) {
        final int value;
        if (ob instanceof Integer) {
            value = (Integer) ob;
        } else if (ob instanceof IdentifiableEnum) {
            value = ((IdentifiableEnum) ob).getId();
        } else {
            throw new Error("Unknown value: type is " + ob.getClass() + " toString is " + ob);
        }
        try {
            return (T) DWIM.getFromInt(cls).invoke(null, value);
        } catch (final Exception e) {
            throw new Error("dwim(" + ob.getClass() + ", " + cls + ") ", e);
        }
    }


    public static <T extends IdentifiableEnum> T[] dwim(final Object[] ob, final Class<T> cls) {
        try {
            final T[] arrayVal = (T[]) Array.newInstance(cls, ob.length);
            for (int i = 0; i < ob.length; i++) {
                arrayVal[i] = DWIM.dwim(ob[i], cls);
            }
            return arrayVal;
        } catch (final Exception e) {
            throw new Error("dwim[](" + ob.getClass() + ", " + cls + ") ", e);
        }
    }

    private static Method getFromInt(final Class<?> cls) throws NoSuchMethodException, SecurityException {
        return cls.getMethod("FromInt", int.class);
    }
}
