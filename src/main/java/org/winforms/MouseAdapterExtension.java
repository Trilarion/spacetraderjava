package org.winforms;

import org.winforms.controls.StatusBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO documentation of usage and better name
public class MouseAdapterExtension extends MouseAdapter {
    private final StatusBar statusBar;
    private final StatusBarPanel source;

    public MouseAdapterExtension(StatusBar statusBar, StatusBarPanel source) {
        this.statusBar = statusBar;
        this.source = source;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (null != statusBar.panelClick) {
            statusBar.panelClick.handle(source, source);
        }
    }
}
