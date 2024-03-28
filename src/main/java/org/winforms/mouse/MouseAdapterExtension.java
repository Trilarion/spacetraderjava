package org.winforms.mouse;

import org.winforms.widget.StatusBar;
import org.winforms.widget.StatusBarPanel;

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
        if (statusBar.panelClick != null) {
            statusBar.panelClick.handle(source, source);
        }
    }
}
