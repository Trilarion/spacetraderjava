package org.winforms;

import javax.swing.*;


public class MenuBar extends Control {
    public MenuBar() {
        super(new JMenuBar());
    }

    public void add(MenuItem item) {
        asJMenuBar().add(item.asJMenuItem());
    }

    public void addAll(MenuItem... items) {
        for (MenuItem item : items) {
            this.add(item);
        }
    }

    private JMenuBar asJMenuBar() {
        return (JMenuBar) swingComponent;
    }
}
