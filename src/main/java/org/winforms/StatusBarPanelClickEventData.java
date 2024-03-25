package org.winforms;

// TODO documentation of usage
public class StatusBarPanelClickEventData implements EventData {  // TODO make StatusBarPanel implementing EventData instead

    public final StatusBarPanel statusBarPanel;

    public StatusBarPanelClickEventData(StatusBarPanel statusBarPanel) {
        this.statusBarPanel = statusBarPanel;
    }
}
