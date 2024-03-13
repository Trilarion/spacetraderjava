package org.winforms;

import javax.swing.*;

// TODO documentation of usage
public class SubMenu extends MenuItem {  // TODO difference to MenuItem
    public SubMenu() {
        super(new JMenu());
    }

    public void add(MenuItem item) {
        asJMenu().add(item.asJMenuItem());
    }

    public void addAll(MenuItem... items) {
        for (MenuItem item : items) {
            this.add(item);
        }
    }

    private JMenu asJMenu() {
        return (JMenu) swingVersion;
    }
}
