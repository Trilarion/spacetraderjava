package org.winforms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuItem {
    public Shortcut Shortcut;
    public int Index;
    protected JMenuItem swingVersion;

    public MenuItem() {
        this(new JMenuItem());
    }

    protected MenuItem(JMenuItem swingVersion) {
        this.swingVersion = swingVersion;
    }

    public JMenuItem asJMenuItem() {
        return swingVersion;
    }

    public void setText(String text) {
        asJMenuItem().setText(text);
    }

    public void setClick(final EventHandler<Object, EventArgs> eventHandler) {
        asJMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                eventHandler.handle(this, null);
            }
        });
    }

    public void setEnabled(boolean enabled) {
        asJMenuItem().setEnabled(enabled);
    }
}
