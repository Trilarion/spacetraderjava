package org.winforms.menu;

import org.winforms.event.EventData;
import org.winforms.event.EventHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuItem {  // TODO composition or inheritance, in this case inheritance might be better?

    protected JMenuItem swingVersion;

    public MenuItem() {
        this(new JMenuItem());
    }

    protected MenuItem(final JMenuItem swingVersion) {
        this.swingVersion = swingVersion;
    }

    public JMenuItem asJMenuItem() {
        return swingVersion;
    }

    public void setText(final String text) {
        asJMenuItem().setText(text);
    }

    public void setClick(EventHandler<Object, EventData> eventHandler) {
        asJMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                eventHandler.handle(this, null);
            }
        });
    }

    public void setEnabled(final boolean enabled) {
        asJMenuItem().setEnabled(enabled);
    }
}
