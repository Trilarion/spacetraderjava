package org.winforms;

// TODO documentation of usage
public class StatusBarPanelClickEventData implements EventData {  // TODO make StatusBarPanel implementing EventData

    public final StatusBarPanel StatusBarPanel;

    public StatusBarPanelClickEventData(StatusBarPanel statusBarPanel) {
        StatusBarPanel = statusBarPanel;
    }
}
