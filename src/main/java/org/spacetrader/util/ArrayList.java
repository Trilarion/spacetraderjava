package org.spacetrader.util;

import java.util.Collection;
import java.util.Collections;

// TODO what is the advantage over the java.util.ArrayList, can we use the inbuilt Arraylist instead
public class ArrayList<T> extends java.util.ArrayList<T> {
    private static final long serialVersionUID = -537394628993404338L;

    public ArrayList(int i) {
        super(i);
    }

    public ArrayList() {
        super();
    }

    public ArrayList(Collection<? extends T> list) {
        super(list);
    }


    public void Sort() {
        Object ob = this;
        Collections.sort((java.util.List<Comparable<Object>>) ob);
    }

    public <U> U[] ToArray(U[] a) {
        return this.toArray(a);
    }

    public void Reverse() {
        Collections.reverse(this);
    }

    public void RemoveRange(int index, int count) {
        removeRange(index, index + count);
    }
}
