package org.winforms.controls;

import org.winforms.MenuItem;

import javax.swing.*;


public class MenuBar extends Control<JMenuBar> {

    public MenuBar() {
        super(new JMenuBar());
    }

    public void add(MenuItem item) {
        asJMenuBar().add(item.asJMenuItem());
    }

    public void addAll(MenuItem... items) {
        for (MenuItem item : items) {
            add(item);
        }
    }

    private JMenuBar asJMenuBar() {
        return (JMenuBar) swingComponent;
    }
}
