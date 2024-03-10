package org.winforms;

// TODO documentation of usage
public class StatusBarPanelClickEventData extends EventData {
    public final StatusBarPanel StatusBarPanel;

    public StatusBarPanelClickEventData(StatusBarPanel statusBarPanel) {
        super();
        StatusBarPanel = statusBarPanel;
    }
}
