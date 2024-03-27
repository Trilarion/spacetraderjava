package org.winforms.widget;

import org.winforms.menu.MenuItem;

import javax.swing.*;


public class MenuBar extends Control<JMenuBar> {

    public MenuBar() {
        super(new JMenuBar());
    }

    public void add(final MenuItem item) {
        asJMenuBar().add(item.asJMenuItem());
    }

    public void addAll(final MenuItem... items) {
        for (final MenuItem item : items) {
            add(item);
        }
    }

    private JMenuBar asJMenuBar() {
        return swingComponent;
    }
}
