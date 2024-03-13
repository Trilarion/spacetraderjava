package org.winforms;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO documentation of usage and better name
class MouseAdapterExtension extends MouseAdapter {
    private final StatusBar statusBar;
    private final StatusBarPanel source;

    MouseAdapterExtension(StatusBar statusBar, StatusBarPanel source) {
        super();
        this.statusBar = statusBar;
        this.source = source;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (statusBar.panelClick != null) {
            statusBar.panelClick.handle(source, new StatusBarPanelClickEventData(source));
        }
    }
}
