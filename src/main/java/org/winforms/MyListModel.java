package org.winforms;

import javax.swing.*;

//TODO inline method, use super-class with template version
public class MyListModel extends DefaultListModel<Object> {
    private static final long serialVersionUID = 1L;

    public void add(Object obj) {
        this.addElement(obj);
    }
}
