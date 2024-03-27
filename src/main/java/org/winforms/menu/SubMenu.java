package org.winforms.menu;

import javax.swing.*;

// TODO documentation of usage
public class SubMenu extends MenuItem {  // TODO difference to MenuItem (JMenu and JMenuItem)
    public SubMenu() {
        super(new JMenu());
    }

    public void add(final MenuItem item) {
        asJMenu().add(item.asJMenuItem());
    }

    public void addSeparator() {
        asJMenu().addSeparator();
    }

    public void addAll(final MenuItem... items) {
        for (final MenuItem item : items) {
            add(item);
        }
    }

    private JMenu asJMenu() {
        return (JMenu) swingVersion;
    }
}
