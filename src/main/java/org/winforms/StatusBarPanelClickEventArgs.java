package org.winforms;


public class StatusBarPanelClickEventArgs extends EventArgs {
    public final StatusBarPanel StatusBarPanel;

    public StatusBarPanelClickEventArgs(StatusBarPanel statusBarPanel) {
        super();
        StatusBarPanel = statusBarPanel;
    }
}
